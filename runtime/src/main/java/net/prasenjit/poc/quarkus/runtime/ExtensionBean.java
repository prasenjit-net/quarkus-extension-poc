package net.prasenjit.poc.quarkus.runtime;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExtensionBean {
    public String greet(String name) {
        return "Hello " + name;
    }
}
