package es.sd.practica1.Entidades;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cultivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "cultivoAplicado")
    List<Tratamiento> tratamientosAplicados;

    private String especie;
    private String variedad;
    private LocalDate fechaPlantado;
    private String zona;

    public Cultivo(String especie, String variedad, LocalDate fechaPlantado, String zona) {
        this.especie = especie;
        this.variedad = variedad;
        this.fechaPlantado = fechaPlantado;
        this.zona = zona;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cultivo() {
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public LocalDate getFechaPlantado() {
        return fechaPlantado;
    }

    public void setFechaPlantado(LocalDate fechaPlantado) {
        this.fechaPlantado = fechaPlantado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
}
