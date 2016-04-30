package todo.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class HelloWorldEndpoint {

    @GET
    public String welcome() {
        return "Hello world endpoint!";
    }

}
