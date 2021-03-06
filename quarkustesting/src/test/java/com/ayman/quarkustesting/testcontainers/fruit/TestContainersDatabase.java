package com.ayman.quarkustesting.testcontainers.fruit;


import java.util.HashMap;
import java.util.Map;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestContainersDatabase implements QuarkusTestResourceLifecycleManager {

    public static final PostgreSQLContainer<?> DATABASE = new PostgreSQLContainer<>("postgres:11.7")
            .withDatabaseName("quarkus_test")
            .withUsername("quarkus_test")
            .withPassword("quarkus_test");

    @Override
    public Map<String, String> start() {
        DATABASE.start();
        Map<String,String> datasourceProperties = new HashMap<>();

        datasourceProperties.put("quarkus.datasource.username", "ayman");
        datasourceProperties.put("quarkus.datasource.password", "ayman");
        datasourceProperties.put("quarkus.datasource.jdbc.url", DATABASE.getJdbcUrl());

        return datasourceProperties;
    }

    @Override
    public void stop() {
        DATABASE.stop();
    }
}
