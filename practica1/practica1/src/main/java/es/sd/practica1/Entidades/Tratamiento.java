package es.sd.practica1.Entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Tratamiento {
    @Id
    private long id;

    @ManyToOne
    private Cultivo cultivoAplicado;
    @ManyToOne
    private Producto productoAplicado;
    
    private String lote;
    private LocalDate fechaInicio;
    private LocalDate finReentrada;
    private LocalDate finRecoleccion;

    public Tratamiento() {
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFinReentrada() {
        return finReentrada;
    }

    public void setFinReentrada(LocalDate finReentrada) {
        this.finReentrada = finReentrada;
    }

    public LocalDate getFinRecoleccion() {
        return finRecoleccion;
    }

    public void setFinRecoleccion(LocalDate finRecoleccion) {
        this.finRecoleccion = finRecoleccion;
    }
    
}
