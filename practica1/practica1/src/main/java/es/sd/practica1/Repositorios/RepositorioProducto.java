package es.sd.practica1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Producto;

public interface RepositorioProducto extends JpaRepository<Producto,Long>{

    Producto findByNombre(String producto); 
    
}
