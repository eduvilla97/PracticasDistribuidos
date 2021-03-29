package es.sd.practica1.Entidades;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cultivo {
    @Id
    private long id;

    @OneToMany(mappedBy = "cultivoAplicado")
    List<Tratamiento> tratamientosAplicados;

    private String especie;
    private String variedad;
    private LocalDate fechaPlantado;
    private String zona;

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
