package com.fovoy.smart.service.es;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.collect.Maps;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;

import java.util.List;
import java.util.Map;

/**
 * Created by zxz.zhang on 15-9-14.
 *
 * @version $Id$
 */
public class QueryBuiler {
    private SearchRequestBuilder  searchRequestBuilder;
    private QueryBuilder queryBuilder;
    private Map<String,String[]> map =Maps.newConcurrentMap();
    private List<QueryBuilder> querys = Lists.newArrayList();

    public QueryBuiler(Map<String, String[]> map, SearchRequestBuilder searchRequestBuilder) {
        this.map = map;
        this.searchRequestBuilder = searchRequestBuilder;
    }




    public SearchHits search(){
        query();
        SearchResponse response =searchRequestBuilder.setSource("*").get();
        return  response.getHits();
    }

    private void query(){
        for (String key:map.keySet()){
            if(key!="size" || key!="page"){
                querys.add(QueryBuilders.termQuery(key, map.get(key)[0]));
            }
        }
        BoolQueryBuilder query =QueryBuilders.boolQuery();
        for (QueryBuilder q :querys){
            query.must(q);
        }
        int page =0;
        if(map.containsKey("page")) {
             page = Integer.parseInt(map.get("page")[0]);
        }
        searchRequestBuilder.setQuery(query).setSize(20).setFrom(20*page);
    }
}
