package com.ayman.quarkustesting.testcontainers.fruit;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(TestContainersDatabase.class)
class FruitResourceTest {


    @Test
    public void testFruit() {
        given().port(8082)
                .when().get("/fruit")
                .then()
                .statusCode(200)
                .body("$.size", is(3)); // `import.sql` has 3 entries for Fruit Entity
    }

}