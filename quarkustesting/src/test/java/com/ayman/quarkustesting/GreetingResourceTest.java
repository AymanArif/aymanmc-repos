package com.ayman.quarkustesting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest //Junit 5
public class GreetingResourceTest {


    // RestAssured
    @Test
    public void testHelloEndpoint() {
        given().port(8082)
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello!"));
    }

}