package ec.edu.uce.infraestructure.repository;

import ec.edu.uce.domain.model.Ciudadanos;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadanosRepositoryImpl implements PanacheRepositoryBase<Ciudadanos, Integer> {

}
