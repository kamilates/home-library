package bookregister.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.scanning.PackageNamesScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import bookregister.rest.HelloWorldEndpoint;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        String[] packages = {"bookregister.rest"};
        registerFinder(new PackageNamesScanner(packages, true));
    }

}