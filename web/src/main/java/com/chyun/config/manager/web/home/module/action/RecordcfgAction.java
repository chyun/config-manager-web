package com.chyun.config.manager.web.home.module.action;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.chyun.config.manager.web.core.PropertyManager;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 类的实现描述: Created by Calix on 27/10/16.
 */
public class RecordcfgAction {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    private PropertyManager propertyManager;

    public void doRecord(Navigator nav, Context cxt) {
        String        keyText = request.getParameter("keyText");
        String        valueText = request.getParameter("valueText");
        propertyManager.addProperty4Schema("config-manager", keyText, valueText);
    }
}
