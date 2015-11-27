package nl.quintor.ee.jaxrs;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@LoggedRequest
public class RequestLoggerFilter implements ContainerRequestFilter {

    @Inject
    Logger log;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        log.info(requestContext.getUriInfo().getAbsolutePath().toString());
    }
}
