package com.ayman.quarkustesting.testcontainers.fruit;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/fruit")
public class FruitResource {

    @GET
    @Produces("application/json")
    public List<Fruit> listFruits() {
        return Fruit.listAll();
    }
}
