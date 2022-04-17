package net.prasenjit.poc.quarkus.runtime;

import javax.inject.Inject;

public class ExtensionBean {

    @Inject
    MyConfig config;

    public String greet(String name) {
        if (name == null) {
            name = config.name();
        }
        return "Hello " + name;
    }
}
