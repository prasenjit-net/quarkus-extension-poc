package net.prasenjit.poc.ext.test;

import net.prasenjit.poc.quarkus.runtime.ExtensionBean;
import net.prasenjit.poc.quarkus.runtime.MyConfig;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * An example resource class
 *
 * @author Prasenjit Purohit
 */
@Path("/exp")
public class ExampleRes {

    @Inject
    ExtensionBean extensionBean;

    @Inject
    MyConfig config;

    /**
     * GET rest resource
     *
     * @param name a name to greet to
     * @return a greeting text
     */
    @GET
    public String greet(@QueryParam("name") String name) {
        return extensionBean.greet(name);
    }
}
