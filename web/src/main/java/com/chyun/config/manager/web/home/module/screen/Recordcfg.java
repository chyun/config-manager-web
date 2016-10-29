package com.chyun.config.manager.web.home.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.chyun.config.manager.web.core.PropertyManager;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类的实现描述: Created by Calix on 27/10/16.
 */
public class Recordcfg {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PropertyManager propertyManager;

    public void execute(Context context) throws Exception {
        String s = request.getParameter("p");
        if ("1".equalsIgnoreCase(s)) {
            context.put("context", null);
            return;
        }

        Map<String, String> map;
        map = propertyManager.getPropertiesBySchema("config-manager");
        context.put("context", map);
    }
}
