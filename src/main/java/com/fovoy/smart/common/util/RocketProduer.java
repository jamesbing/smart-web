package com.fovoy.smart.common.util;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * Created by zxz.zhang on 15-9-24.
 *
 * @version $Id$
 */
public enum RocketProduer {
    SMART("ProducerGroupName");
    private final String groupName;
    private DefaultMQProducer producer;
    private RocketProduer(String groupName){
        this.groupName=groupName;
        this.init();
    }

    private void init(){
        producer=new DefaultMQProducer(groupName);
        producer.setNamesrvAddr("192.168.114.155:9876");
        producer.setInstanceName("Producer");
        try {
            producer.start();

        Message msg = new Message("TopicTest1",// topic
                "TagA",// tag
                "OrderID001",// key
                ("Hello MetaQA").getBytes());// body
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public DefaultMQProducer producer(){
        return this.producer;
    }

}
