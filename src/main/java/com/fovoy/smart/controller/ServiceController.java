package com.fovoy.smart.controller;

import java.util.List;
import java.util.Map;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.fovoy.smart.common.util.RocketProduer;
import com.fovoy.smart.model.Service;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zxz.zhang on 15-9-11.
 *
 * @version $Id$
 */
public class ServiceController extends Controller {
    private final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    private final String indexName = PropKit.use("rock.properties").get("indexName");
    private final String indexType = PropKit.use("rock.properties").get("indexType");
    private final String Topic = PropKit.use("rock.properties").get("topic");
    private final String Tag = PropKit.use("rock.properties").get("tag");
    private final String score = PropKit.use("rock.properties").get("score");
    private final String NAME = "name";
    private final String PHONE = "phone";
    private final DefaultMQProducer producer = RocketProduer.SMART.producer();

    public void index() {
        renderText("SUCCESS");
    }

    public void findByDes() {
        String destination = getPara("des");
        List<Service> list = Service.dao.find("select * from service");
    }

    public void find() {
        String id = getPara("id");
        String page = getPara("page");
        if (id != null) {
            Service service = Service.dao.findById(id);
            if (service == null)
                redirect("/404.html");
            renderJson(service);
        } else {
            int pg = 0;
            if (page != null) {
                pg = Integer.parseInt(page);
            }
            List<Service> list = Service.dao.find("select * from service limit " + (pg * 20) + " ,20");
            renderJson(list);
        }

    }
    //TODO 搜索
    // public void search(){
    // SearchRequestBuilder sr
    // =EsClient.SEARCHCLIENT.client().prepareSearch(indexName).setTypes(indexType).addSort(score,
    // SortOrder.ASC);
    // QueryBuiler queryBuiler = new QueryBuiler(getParaMap(),sr);
    // SearchHits search=queryBuiler.search();
    // if(search!=null) {
    // renderJson(search);
    // }
    // }

    public void save() {
        Map<String, String[]> map = getParaMap();
        Service service = getModel(Service.class);
        Service.dao.setAttrs(service).save();
    }

    // public void saveEs(Map<String, String[]> map){
    // IndexRequestBuilder indexRequestBuilder =EsClient.SEARCHCLIENT.client().prepareIndex(indexName, indexType);
    // indexRequestBuilder.setId(map.get("id")[0]);
    // indexRequestBuilder.setSource(map);
    // indexRequestBuilder.get();
    // }

    public void sendOrder() {
        Map<String, String[]> map = getParaMap();
        Message message = new Message(Topic,Tag,map.get(PHONE)[0],map.get(NAME)[0].getBytes());
        SendResult result =null;
        try {
             result=producer.send(message);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(result.toString());
        renderText("success");
    }

}
