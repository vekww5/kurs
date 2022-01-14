package ru.rsatu.resource;

import ru.rsatu.pojo.Section;
import ru.rsatu.service.SectionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sections")
public class SectionResource {

    @Inject
    SectionService ss;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSections")
    public Response getSections(){
        return Response.ok(ss.getSections()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getSectionById")
    public Response getSectionById(@QueryParam("id_section") Long id_section){
        return Response.ok(ss.getSectionById(id_section)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertSection")
    public Response insertSection(Section tr){
        return Response.ok(ss.insertSection(tr)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateSection")
    public Response updateSection(Section tr){
        return Response.ok(ss.updateSection(tr)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id_section}")
    public Response deleteSection(@PathParam("id_section") Long id_section){
        ss.deleteSection(id_section);
        return Response.ok().build();
    }

}
