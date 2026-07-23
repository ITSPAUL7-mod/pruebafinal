package ec.edu.uce.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.domain.model.Ciudadanos;

@Path("/ciudadanos")
public class CiudadanoController {

    @Inject
    private CiudadanoService cs;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void guardar(List<Ciudadanos> ciudadanos) throws Exception {
        
        this.cs.guardarTxt(ciudadanos);
    }
}