package es.sd.practica1.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sd.practica1.Entidades.Producto;
import es.sd.practica1.Repositorios.RepositorioProducto;

@Service
public class ServicioProducto {
    @Autowired
    private RepositorioProducto repositorio;

    public List<Producto> findAll() {
        return repositorio.findAll();
    }

    public Producto findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
    
}
