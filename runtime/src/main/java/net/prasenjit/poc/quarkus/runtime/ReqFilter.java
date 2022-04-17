package net.prasenjit.poc.quarkus.runtime;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * An example JaxRs Filter provided from extension
 *
 * @author Prasenjit Purohit
 */
@Provider
public class ReqFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println(requestContext.getUriInfo().getPath());
    }
}
