package ru.rsatu.resource;

import ru.rsatu.pojo.Schedule;
import ru.rsatu.service.ScheduleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/schedules")
public class ScheduleResource {

    @Inject
    ScheduleService ssch;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSchedules")
    public Response getSchedules(){
        return Response.ok(ssch.getSchedules()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getScheduleById")
    public Response getScheduleById(@QueryParam("id_schedule") Long id_schedule){
        return Response.ok(ssch.getScheduleById(id_schedule)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertSchedule")
    public Response insertSchedule(Schedule tr){
        return Response.ok(ssch.insertSchedule(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateSchedule")
    public Response updateSchedule(Schedule tr){
        return Response.ok(ssch.updateSchedule(tr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_schedule}")
    public Response deleteSchedule(@PathParam("id_schedule") Long id_schedule){
        ssch.deleteSchedule(id_schedule);
        return Response.ok().build();
    }

}
