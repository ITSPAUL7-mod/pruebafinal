package ec.edu.uce.web.resource;

import ec.edu.uce.application.service.VehiculoService;
import ec.edu.uce.domain.model.Vehiculo;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/vehiculo")
public class VehiculoResource {

    @Inject
    private VehiculoService vs;


    @Path("/guardar")
    @POST
    public void guardar(Vehiculo vehiculo){

        this.vs.guardar(vehiculo);

    }

    @Path("/buscar/{placa}")
    @GET
    public void buscar(@PathParam("placa") String placa){

        this.vs.buscar(placa);

    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar(@PathParam("id") Integer id){

        this.vs.eliminar(id);

    }

    @Path("/actualizar")
    @PUT
    public void actualizar(Vehiculo vehiculo){

        this.vs.actualizar(vehiculo);

    }




}
