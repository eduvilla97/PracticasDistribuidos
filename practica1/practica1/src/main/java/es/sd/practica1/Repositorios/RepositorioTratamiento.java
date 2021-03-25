package es.sd.practica1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Tratamiento;

public interface RepositorioTratamiento extends JpaRepository<Tratamiento,Long>{
    
}
