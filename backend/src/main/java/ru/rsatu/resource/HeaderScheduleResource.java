package ru.rsatu.resource;

import ru.rsatu.pojo.HeaderSchedule;
import ru.rsatu.service.HeaderScheduleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/headerschedules")
public class HeaderScheduleResource {

    @Inject
    HeaderScheduleService shs;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getHeaderSchedules")
    public Response getHeaderSchedules(){
        return Response.ok(shs.getHeaderSchedules()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getHeaderScheduleById")
    public Response getHeaderScheduleById(@QueryParam("id_header_schedule") Long id_header_schedule){
        return Response.ok(shs.getHeaderScheduleById(id_header_schedule)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertHeaderSchedule")
    public Response insertHeaderSchedule(HeaderSchedule tr){
        return Response.ok(shs.insertHeaderSchedule(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateHeaderSchedule")
    public Response updateHeaderSchedule(HeaderSchedule tr){
        return Response.ok(shs.updateHeaderSchedule(tr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_header_schedule}")
    public Response deleteHeaderSchedule(@PathParam("id_header_schedule") Long id_header_schedule){
        shs.deleteHeaderSchedule(id_header_schedule);
        return Response.ok().build();
    }

}
