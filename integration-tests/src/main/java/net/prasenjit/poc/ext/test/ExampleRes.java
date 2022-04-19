package net.prasenjit.poc.ext.test;

import net.prasenjit.poc.quarkus.runtime.ExtensionBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * An example resource class
 *
 * @author Prasenjit Purohit
 */
@Path("/exp")
public class ExampleRes {

    @Inject
    ExtensionBean extensionBean;

    /**
     * GET rest resource
     *
     * @param name a name to greet to
     * @return a greeting text
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@QueryParam("name") String name) {
        return extensionBean.greet(name);
    }
}
