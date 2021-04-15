package es.sd.practica1.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Cultivo;

public interface RepositorioCultivo extends JpaRepository<Cultivo,Long>{ 
    Optional<Cultivo> findById(Long id);

    Cultivo findByEspecie(String especie); 
    
}
