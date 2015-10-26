package com.fovoy.smart.config.route;

import com.fovoy.smart.controller.ServiceController;
import com.jfinal.config.Routes;

/**
 * Created by zxz.zhang on 15-9-11.
 *
 * @version $Id$
 */
public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/smart/service", ServiceController.class);
    }
}
