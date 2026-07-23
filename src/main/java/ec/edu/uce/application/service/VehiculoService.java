package ec.edu.uce.application.service;

import ec.edu.uce.application.interceptor.Auditoria;
import ec.edu.uce.domain.model.Vehiculo;
import ec.edu.uce.infraestructure.repository.VehiculoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VehiculoService {

    @Inject
    private VehiculoRepositoryImpl vri;


    @Auditoria
    public void guardar(Vehiculo vehiculo){

        this.vri.persist(vehiculo);

    }

    @Auditoria
    public Vehiculo buscar(String placa){
        return (Vehiculo) this.vri.find("placa",placa).firstResult();
    }

    @Auditoria
    public void eliminar(Integer id){

        this.vri.deleteById(id);

    }

    @Auditoria
    public void actualizar(Vehiculo vehiculo){
        Vehiculo v = this.vri.findById(vehiculo.getId());
        v.setPlaca(vehiculo.getPlaca());
        this.vri.getEntityManager().merge(vehiculo);
    }


}
