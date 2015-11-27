package nl.quintor.ee.jaxrs;

import nl.quintor.ee.cdi.Property;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("options")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class OptionsEndpoint {

    private List<Option> options = new ArrayList<>();

    @Inject
    Event<String> event;

    @PostConstruct
    private void init() {
        options.add(new Option("sushi"));
        options.add(new Option("pizza"));
    }

    @GET
    public List<Option> getOptions() {
        event.fire("Get options requested");
        return options;
    }

    @POST
    @LoggedRequest
    public Response addOption(@Valid Option option) {
        options.add(option);
        return Response.created(URI.create("/")).build();
    }

    @GET
    @Path("slow")
    public void getSlowOptions(@Suspended AsyncResponse response) {
        new Thread(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.resume(options);
        }).start();
    }


}
