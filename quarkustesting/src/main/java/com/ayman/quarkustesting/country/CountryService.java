package com.ayman.quarkustesting.country;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/v2")
@RegisterRestClient
@ApplicationScoped //Scoping issues in Quarkus. Mocking does not work without this dependency.
public interface CountryService {

    @GET
    @Produces("application/json")
    @Path("/name/{name}")
    List<Country> getByName(@PathParam("name") String name);
}
