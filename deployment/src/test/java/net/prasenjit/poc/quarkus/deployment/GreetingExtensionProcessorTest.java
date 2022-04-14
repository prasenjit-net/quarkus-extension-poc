package net.prasenjit.poc.quarkus.deployment;

import io.quarkus.test.QuarkusUnitTest;
import net.prasenjit.poc.quarkus.runtime.ExtensionBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import javax.inject.Inject;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GreetingExtensionProcessorTest {

    @RegisterExtension
    static final QuarkusUnitTest config = new QuarkusUnitTest()
            .withEmptyApplication();

    @Inject
    ExtensionBean extensionBean;

    @Test
    public void testGreeting() {
        when().get("/poc")
                .then().assertThat()
                .statusCode(200).body(containsString("Hello"));
    }

    @Test
    public void testBean() {
        assertNotNull(extensionBean);
    }
}
