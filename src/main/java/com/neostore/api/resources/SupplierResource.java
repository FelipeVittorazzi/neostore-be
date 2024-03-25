package com.neostore.api.resources;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.neostore.domain.model.Supplier;
import com.neostore.domain.service.SupplierService;

@Path("/supplier")
public class SupplierResource {

    private final SupplierService fornecedorService = new SupplierService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> get(@QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("5") int size) {
        return fornecedorService.getAll(page, size);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        try {
            Supplier supplier = fornecedorService.getById(id);
            return Response.status(Response.Status.OK).entity(supplier).build();

        } catch (WebApplicationException ex) {
            ex.printStackTrace();
            return Response.status(ex.getResponse().getStatus()).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("/cnpj/{cnpj}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCnpj(@PathParam("cnpj") String cnpj) {
        try {
            Supplier supplier = fornecedorService.findByCnpj(cnpj);
            return Response.status(Response.Status.OK).entity(supplier).build();
        } catch (WebApplicationException ex) {
            ex.printStackTrace();
            return Response.status(ex.getResponse().getStatus()).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByEmail(@PathParam("email") String email) {
        try {
            Supplier supplier = fornecedorService.findByEmail(email);
            return Response.status(Response.Status.OK).entity(supplier).build();
        } catch (WebApplicationException ex) {
            ex.printStackTrace();
            return Response.status(ex.getResponse().getStatus()).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Supplier supplier) {
        try {
            fornecedorService.post(supplier);
            return Response.status(Response.Status.CREATED).entity(supplier).build();
        } catch (WebApplicationException ex) {
            ex.printStackTrace();
            return Response.status(ex.getResponse().getStatus()).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Path("/import")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response importSuppliers(List<Supplier> suppliers) {
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, @Valid Supplier supplier) {
        try {
            fornecedorService.put(id, supplier);
            return Response.status(Response.Status.OK).entity(supplier).build();

        } catch (WebApplicationException ex) {
            ex.printStackTrace();
            return Response.status(ex.getResponse().getStatus()).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {

            fornecedorService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();

        } catch (WebApplicationException ex) {
            ex.printStackTrace();
            return Response.status(ex.getResponse().getStatus()).entity(ex.getMessage()).build();
        }
    }
}