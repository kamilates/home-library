package bookregister.rest;

import bookregister.service.EnumValueListingService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("enums")
public class EnumEndpoint {

    private EnumValueListingService enumValueListingService;

    @Inject
    public EnumEndpoint(EnumValueListingService enumValueListingService) {
        this.enumValueListingService = enumValueListingService;
    }

    @GET
    @Path("{enumName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllValues(@PathParam("enumName") String enumName) {
        List<String> enumValues = enumValueListingService.getValuesForEnum(enumName);
        if (enumValues == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(enumValues).build();
    }
}
