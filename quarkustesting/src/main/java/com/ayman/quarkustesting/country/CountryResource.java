package com.ayman.quarkustesting.country;


import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/country")
public class CountryResource { // In Spring world, a Controller

    private final CountryService countryService;


    public CountryResource(@RestClient CountryService countryService) { // RestClient CDI
        this.countryService = countryService;
    }

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    public List<Country> getByName(@PathParam("name") String name) {
        return countryService.getByName(name);
    }
}
