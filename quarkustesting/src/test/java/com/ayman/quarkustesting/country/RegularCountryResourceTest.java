package com.ayman.quarkustesting.country;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class RegularCountryResourceTest {

    // RestAssured
    @Test
    public void testGreece() {
        given().port(8082)
                .when().get("/country/name/Greece")
                .then()
                .statusCode(200)
                .body("$.size", is(1),
                        "[0].name", is("Greece"));
    }

    @Test
    public void testFrance() {
        given().port(8082)
                .when().get("/country/name/france")
                .then()
                .statusCode(200)
                .body("$.size", is(0));
    }


}