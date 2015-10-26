package com.fovoy.smart.common.util;

import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zxz.zhang on 15-8-19
 */
public enum EsClient {
    SEARCHCLIENT("1"), INDEXCLIENT("2");
    private final static Logger logger = LoggerFactory.getLogger(EsClient.class);
    private String key = null;
    private ResourceBundle rb = ResourceBundle.getBundle("es", Locale.getDefault());
    private TransportClient client;

    private EsClient(String key) {
        this.key = key;
        this.init();
    }
    private void init() {

        try {
            String clusterName = rb.getString(StringUtils.join("cluster.name", ".", key));
            String nodeAddress = rb.getString(StringUtils.join("node.address", ".", key));
            Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", clusterName)
                    .put("client.transport.sniff", true).build();
            client = new TransportClient(settings);
            String[] addressArr = nodeAddress.split(",");
            for (String address : addressArr) {
                String[] ipAndPort = address.split(":");
                client.addTransportAddress(new InetSocketTransportAddress(ipAndPort[0], Integer.parseInt(ipAndPort[1])));
            }
        } catch (Exception e) {
            logger.error("EsClientUtils error", e);
        }
    }

    public TransportClient client() {
        return this.client;
    }
}
