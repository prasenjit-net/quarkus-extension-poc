package net.prasenjit.poc.quarkus.runtime;

import javax.inject.Inject;

/**
 * An example bean
 *
 * @author Prasenjit Purohit
 */
public class ExtensionBean {

    @Inject
    MyConfig config;

    /**
     * A greeter method
     *
     * @param name name to greet to
     * @return greeting message
     */
    public String greet(String name) {
        if (name == null) {
            name = config.name();
        }
        return "Hello " + name;
    }
}
