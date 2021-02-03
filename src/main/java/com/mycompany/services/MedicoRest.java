package com.mycompany.services;

import com.mycompany.entidades.Medico;
import com.mycompany.session.MedicoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Medico")
public class MedicoRest {
     @EJB
    private MedicoFacade medicoFacade;
    
     //VAMOS A TRAER LOS DATOS DE LA TABLA DE LA BDD
    @GET
    //CON UN FORMATO JSON
    @Produces({MediaType.APPLICATION_JSON})
    public List<Medico> findAll() {
        return medicoFacade.findAll();
    }
    
    //TRAER UN ID ESPECIFICO DE LA BASE DE DATOS
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Medico findById(@PathParam("id") Integer id) {
        return medicoFacade.find(id);
    }
}
