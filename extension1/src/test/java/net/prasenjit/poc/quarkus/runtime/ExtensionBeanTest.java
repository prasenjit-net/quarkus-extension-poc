package net.prasenjit.poc.quarkus.runtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExtensionBeanTest {

    private ExtensionBean extensionBean;

    @BeforeEach
    public void setup() {
        extensionBean = new ExtensionBean();
        extensionBean.config = new MyConfig() {
            @Override
            public String name() {
                return "Quarkus";
            }
        };
    }

    @Test
    public void testGreet() {
        String greet = extensionBean.greet(null);
        assertEquals("Hello Quarkus", greet);

        greet = extensionBean.greet("World");
        assertEquals("Hello World", greet);
    }

}
