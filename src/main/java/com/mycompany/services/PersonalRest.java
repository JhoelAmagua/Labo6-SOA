package com.mycompany.services;


import com.mycompany.entidades.Personal;
import com.mycompany.session.PersonalFacade;
import java.util.List;
import javax.ejb.EJB;
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

@Path("Personal")
public class PersonalRest 
{
    @EJB
    private PersonalFacade personalFacade;
    
     //VAMOS A TRAER LOS DATOS DE LA TABLA DE LA BDD
    @GET
    //CON UN FORMATO JSON
    @Produces({MediaType.APPLICATION_JSON})
    public List<Personal> findAll() {
        return personalFacade.findAll();
    }
    
    //TRAER UN ID ESPECIFICO DE LA BASE DE DATOS
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Personal findById(@PathParam("id") Integer id) {
        return personalFacade.find(id);
    }

    //BORRAR UN ID ESPECIFICO DE LA BASE DE DATOS
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        personalFacade.remove(personalFacade.find(id));
        
        String message = "Eliminado Correctamente !!";
        return Response.ok(message).build();
    }

    //INSERTAR UN ELEMENTO EN LA BASE DE DATOS
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Personal personal) {
        personalFacade.create(personal);
        
        String message = "Insertado Correctamente !!";
        return Response.ok(message).build();
    }

    //ACTUALIZAR UN ID ESPECIFICO DE LA BASE DE DATOS
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Personal personal) 
    {
        if (personalFacade.find(id) != null) {
            personal.setId(id);
            personalFacade.edit(personal); 
        }
        String message = "Actualizado Correctamente !!";
        return Response.ok(message).build();
        
    }
   
}