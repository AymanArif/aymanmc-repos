package com.ayman.quarkustesting.country;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@QuarkusTestResource(WiremockCountries.class)
class CountryServiceTest {

    @Inject
    @RestClient
    CountryService countryService;



    @Test
    void testGR() {
        assertThat(countryService.getByName("GR"))
                    .hasSize(10)
                    .extracting("name")
                    .contains("Greece");
    }
}