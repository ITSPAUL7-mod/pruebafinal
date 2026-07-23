package ec.edu.uce.application.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import ec.edu.uce.domain.model.Ciudadanos;
import ec.edu.uce.infraestructure.repository.CiudadanosRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CiudadanoService {

    @Inject
    private CiudadanosRepositoryImpl ciudadanosRepository; 

    @Transactional
    public void guardar(Ciudadanos ciudadano) {
        this.ciudadanosRepository.persist(ciudadano);
    }

    @Transactional
    public void guardarTxt(List<Ciudadanos> lista) throws Exception {
        for (Ciudadanos ciu : lista) {
            this.ciudadanosRepository.persist(ciu);
        }

        Path path = Paths.get(System.getProperty("user.home"), "ciudadanos_guardados.txt");

        List<String> datos = lista.stream()
                .map(c -> c.getCedula() + "," + c.getNombre() + "," + c.getApellido())
                .collect(Collectors.toList());

        Files.write(path, datos, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}