package com.msquared;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HitchARide.class);
        register(CleanMyHouse.class);
        register(FeedMe.class);
        register(Groceries.class);
    }

}
