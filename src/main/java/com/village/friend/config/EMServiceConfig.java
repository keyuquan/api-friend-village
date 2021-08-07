package com.village.friend.config;

import com.easemob.im.server.EMProperties;
import com.easemob.im.server.EMService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class EMServiceConfig {
    @Value("${im.appKey}")
    private String appKey;

    @Value("${im.clientId}")
    private String clientId;

    @Value("${im.clientSecret}")
    private String clientSecret;

    @Bean(name = "EMService")
    public synchronized EMService getEMService() {
        EMProperties properties = EMProperties.builder()
                .setAppkey(appKey)
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
        EMService service = new EMService(properties);
        return service;
    }

}
