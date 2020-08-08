package com.ayman.quarkustesting.country;


import java.util.Collections;
import java.util.Map;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockCountries implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();

        stubFor(get(urlEqualTo("/v2/name/GR"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                                "[\n" +
                                        "                                    {\n" +
                                        "                                        \"name\": \"Ελλάδα\",\n" +
                                        "                                        \"capital\": \"Αθήνα\"\n" +
                                        "                                    }\n" +
                                        "                                ]"
                        )));

        stubFor(get(urlMatching(".*")).atPriority(10)
                .willReturn(aResponse().proxiedFrom("https://restcountries.eu/rest")));

        return Collections.singletonMap("org.acme.getting.started.country.CountriesService/mp-rest/url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (null != wireMockServer) {
            wireMockServer.stop();
        }
    }
}