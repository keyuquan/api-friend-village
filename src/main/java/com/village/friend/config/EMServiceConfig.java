package com.village.friend.config;

import com.easemob.im.server.EMProperties;
import com.easemob.im.server.EMService;

public class EMServiceConfig {
    public static void main(String[] args) {
        EMProperties properties = EMProperties.builder()
                .setAppkey("1148210717097900#demo")
                .setClientId("YXA6go3iD_7ORWqHW17YER8M5Q")
                .setClientSecret("YXA65t40PgMxozp6X6PIKnoR3mInxAI")
                .build();

        EMService service = new EMService(properties);

        service.user().create("ke123456789", "ke123456789");

    }
}
