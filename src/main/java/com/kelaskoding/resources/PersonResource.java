/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kelaskoding.resources;

import com.kelaskoding.model.Person;
import com.kelaskoding.repository.PersonRepo;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jarvis
 */
@Path("/persons")
public class PersonResource {
    
    private PersonRepo repo = null;
    
    public PersonResource(){
        this.repo = new PersonRepo();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> findAll(){       
        return repo.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findById(@PathParam("id") int id){
        return Response.ok(repo.findById(id)).build();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOne(Person person){       
        return Response.ok(repo.createOne(person)).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response removeById(@PathParam("id") int id){
        return Response.ok().build();
    }
    
    @PUT
    @Path("/{id}")
    public Response updateOne(@PathParam("id") int id, Person person){
        Person temp = repo.update(id, person);
        if(temp==null){
            return Response.status(Response.Status.NOT_MODIFIED).build();
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
