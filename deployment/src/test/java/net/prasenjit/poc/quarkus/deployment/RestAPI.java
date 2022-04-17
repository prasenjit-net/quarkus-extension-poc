package net.prasenjit.poc.quarkus.deployment;

import net.prasenjit.poc.quarkus.runtime.ExtensionBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestAPI {

    @Inject
    ExtensionBean extensionBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAPI() {
        return "a text";
    }

    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@QueryParam("name") String name) {
        return extensionBean.greet(name);
    }
}
