package com.example.insta_test;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class IGDevice implements Serializable {
    private static final long serialVersionUID = -823447845648l;
    private final String userAgent;
    private final String capabilities;
    private final Map<String, Object> deviceMap;

    public IGDevice(String userAgent, String capabilities, Map<String, Object> deviceMap) {
        this.userAgent = userAgent;
        this.capabilities = capabilities;
        this.deviceMap = deviceMap;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public Map<String, Object> getDeviceMap() {
        return deviceMap;
    }
}
