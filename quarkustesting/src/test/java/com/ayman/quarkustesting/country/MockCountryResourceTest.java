package com.ayman.quarkustesting.country;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.activation.CommandInfo;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class MockCountryResourceTest {


    // NOTE: Use @ApplicationScope annotation in CountryService
    @InjectMock
    @RestClient
    CountryService countryService;

    @BeforeEach
    void setUp(){
        Mockito.when(countryService.getByName("Greece"))
                .thenReturn(Collections.singletonList(new Country("Hellenic Republic", "Athens")));
    }


    // RestAssured
    @Test
    public void testGreece() {
        given().port(8082)
                .when().get("/country/name/Greece")
                .then()
                .statusCode(200)
                .body("$.size", is(1),
                        "[0].name", is("Hellenic Republic"));
    }

}