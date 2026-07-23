package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "ciudadanos")
@Entity
public class Ciudadanos {

    @Id
    @SequenceGenerator(name = "seq_ciudadanos_generador", sequenceName = "seq_ciudadanos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciudadanos_generador")
    @Column(name = "ciud_id")
    private Integer cedula;
    @Column(name = "ciud_nombre")
    private String nombre;
    @Column(name = "ciud_apellido")
    private String apellido;
    @Column(name = "ciud_genero")
    private String genero;

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
