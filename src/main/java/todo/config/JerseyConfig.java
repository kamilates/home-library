package todo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import todo.rest.HelloWorldEndpoint;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloWorldEndpoint.class);
    }

}