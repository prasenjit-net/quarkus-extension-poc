package net.prasenjit.poc.ext.test;

import net.prasenjit.poc.quarkus.runtime.ExtensionBean;
import net.prasenjit.poc.quarkus.runtime.MyConfig;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/exp")
public class ExampleRes {

    @Inject
    ExtensionBean extensionBean;

    @Inject
    MyConfig config;

    @GET
    public String greet(@QueryParam("name") String name) {
        return extensionBean.greet(name);
    }
}
