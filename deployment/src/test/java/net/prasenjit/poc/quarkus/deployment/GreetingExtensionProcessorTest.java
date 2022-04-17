package net.prasenjit.poc.quarkus.deployment;

import io.quarkus.test.QuarkusUnitTest;
import net.prasenjit.poc.quarkus.runtime.ExtensionBean;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GreetingExtensionProcessorTest {

    @RegisterExtension
    static final QuarkusUnitTest config = new QuarkusUnitTest()
            .setArchiveProducer(() -> {
                return ShrinkWrap.create(JavaArchive.class)
                        .addClasses(RestAPI.class)
                        .addAsResource("application.properties");
            });

    @Inject
    ExtensionBean extensionBean;

    @Test
    public void testGreeting() {
        when().get("/poc")
                .then().assertThat()
                .statusCode(200).body(containsString("Hello"));
    }

    @Test
    public void testFilter() {
        when().get("/rest")
                .then().assertThat()
                .statusCode(200).body(containsString("a text"));
    }

    @Test
    public void testGreeter() {
        given().queryParam("name", "World")
                .get("/rest/greet").then().assertThat()
                .statusCode(200).body(containsString("Hello World"));
        given().get("/rest/greet").then().assertThat()
                .statusCode(200).body(containsString("Hello Universe"));
    }

    @Test
    public void testBean() {
        assertNotNull(extensionBean);
    }
}
