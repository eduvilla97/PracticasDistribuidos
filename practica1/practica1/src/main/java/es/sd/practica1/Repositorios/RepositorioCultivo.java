package es.sd.practica1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Cultivo;

public interface RepositorioCultivo extends JpaRepository<Cultivo,Long>{

    Cultivo findByNombre(String nombre); 
    
}
