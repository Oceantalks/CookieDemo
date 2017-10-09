package com.cybercom.demo.resource;

import com.cybercom.demo.model.Person;
import com.cybercom.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.HttpCookie;
import java.net.URI;

@Component
@Path("/createPerson")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class PersonResource {

    @Autowired
    private PersonService ps;

    @POST
    public Response createPerson(Person person, @Context UriInfo uriInfo) {
        Person newPerson = ps.createPerson(person);
        String id = String.valueOf(person.getId());
        URI newUserURILocation = uriInfo.getAbsolutePathBuilder().path(id).build();
        Cookie cookie = new Cookie("Token", "Här har vi vår kaka för vår JWT");
        return Response.created(newUserURILocation).entity(newPerson).header("Set-Cookie", cookie).build();
    }


}
