package net.prasenjit.poc.ext.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class ExampleResTest {

    @Test
    void greet() {
        given().get("/exp")
                .then().assertThat()
                .statusCode(200)
                .body(is("Hello Quarkus"));
    }

    @Test
    void greetWorld() {
        given().queryParam("name", "World").get("/exp")
                .then().assertThat()
                .statusCode(200)
                .body(is("Hello World"));
    }
}
