package bookregister.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import bookregister.rest.HelloWorldEndpoint;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloWorldEndpoint.class);
    }

}