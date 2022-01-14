package ru.rsatu.resource;

import ru.rsatu.pojo.Trainer;
import ru.rsatu.service.TrainerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/trainers")
public class TrainerResource {

    @Inject
    TrainerService ts;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainers")
    public Response getTrainers(){
        return Response.ok(ts.getTrainers()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTrainerById")
    public Response getTrainerById(@QueryParam("id_trainer") Long id_trainer){
        return Response.ok(ts.getTrainerById(id_trainer)).build();
    }

    @POST
    @Path("/insertTrainer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertTrainer(Trainer tr){
        return Response.ok(ts.insertTrainer(tr)).build();
    }

    @POST
    @Path("/updateTrainer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTrainer(Trainer tr){
        return Response.ok(ts.updateTrainer(tr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_trainer}")
    public Response deleteTrainer(@PathParam("id_trainer") Long id_trainer){
        ts.deleteTrainer(id_trainer);
        return Response.ok().build();
    }



}
