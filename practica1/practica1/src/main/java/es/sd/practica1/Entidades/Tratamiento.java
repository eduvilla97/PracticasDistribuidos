package es.sd.practica1.Entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Producto getProductoAplicado() {
        return productoAplicado;
    }

    public void setProductoAplicado(Producto productoAplicado) {
        this.productoAplicado = productoAplicado;
    }

    public Cultivo getCultivoAplicado() {
        return cultivoAplicado;
    }

    public void setCultivoAplicado(Cultivo cultivoAplicado) {
        this.cultivoAplicado = cultivoAplicado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Tratamiento(Cultivo cultivoAplicado, Producto productoAplicado, String lote, LocalDate fechaInicio,
            LocalDate finReentrada, LocalDate finRecoleccion) {
        this.setCultivoAplicado(cultivoAplicado);
        this.setProductoAplicado(productoAplicado);
        this.lote = lote;
        this.fechaInicio = fechaInicio;
        this.finReentrada = finReentrada;
        this.finRecoleccion = finRecoleccion;
    }
    
}
