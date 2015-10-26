package com.fovoy.smart.config;

import com.fovoy.smart.common.util.EsClient;
import com.fovoy.smart.common.util.RocketProduer;
import com.fovoy.smart.config.route.AdminRoutes;
import com.fovoy.smart.model.Orders;
import com.fovoy.smart.model.Service;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * Created by zxz.zhang on 15-9-11.
 *
 * @version $Id$
 */
public class SmartConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        Prop p =PropKit.use("rock.properties");
        me.setDevMode(p.getBoolean("devMode"));
        EsClient.INDEXCLIENT.client();
        EsClient.SEARCHCLIENT.client();
        // me.setViewType(ViewType.JSP);
        RocketProduer.SMART.producer();
    }

    @Override
    public void configHandler(Handlers me) {

    }
    @Override
    public void configInterceptor(Interceptors me) {
    }

    @Override
    public void configPlugin(Plugins me) {
        Prop p =PropKit.use("db.properties");
        DruidPlugin dp = new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("pas"));
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(dp);
        me.add(arp);
        arp.addMapping("service", Service.class);
        arp.addMapping("orders", Orders.class);
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new AdminRoutes());
    }
}
