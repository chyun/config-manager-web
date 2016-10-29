package com.chyun.config.manager.web.core;

import com.chyun.config.manager.api.ConfigManagerService;
import com.chyun.config.manager.api.request.ReadPropertiesBySchemaReq;
import com.chyun.config.manager.api.request.SetPropertyReq;
import com.chyun.config.manager.api.response.ReadPropertiesBySchemaResp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 类的实现描述: Created by Calix on 16/10/16.
 */
public class PropertyManager {
    private final Logger LOGGER = LoggerFactory.getLogger(PropertyManager.class);

    @Autowired
    private ConfigManagerService configManagerService;

    public Map<String, String> getPropertiesBySchema(String schema) {
        ReadPropertiesBySchemaReq request = new ReadPropertiesBySchemaReq();
        request.setSchema(schema);
        try {
            ReadPropertiesBySchemaResp resp = configManagerService.readPropertiesBySchema(request);
            if (null == resp) {
                LOGGER.error("ReadPropertiesBySchemaResp.null");
            }
            return resp.getValues();
        } catch (Exception e) {
            LOGGER.error("ConfigManagerService.readPropertiesBySchema.error", e);
        }
        return null;
    }

    public boolean addProperty4Schema(String schema, String prop, String value) {
        SetPropertyReq setPropertyReq = new SetPropertyReq();
        setPropertyReq.setSchema(schema);
        setPropertyReq.setKey(prop);
        setPropertyReq.setValue(value);
        try {
            configManagerService.setProperty(setPropertyReq);
            return true;
        } catch (Exception e) {
            LOGGER.error("ConfigManagerService.error", e);
        }
        return false;
    }
}
