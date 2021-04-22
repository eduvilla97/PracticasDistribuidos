package es.sd.practica1.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sd.practica1.Entidades.Producto;
import es.sd.practica1.Repositorios.RepositorioProducto;

@Service
public class ServicioProducto {
    @Autowired
    private RepositorioProducto repositorio;

    public void save(Producto nuevoProducto) {
        repositorio.save(nuevoProducto);
    }

    public List<Producto> findAll() {
        return repositorio.findAll();
    }

    public Producto findById(long id) {
        Optional<Producto> productoInDB = repositorio.findById(id);
        if(productoInDB.isPresent()) return productoInDB.get();
        return null;
    }

    public Producto findByNombre(String producto) {
        return repositorio.findByNombre(producto);
    }
    
}