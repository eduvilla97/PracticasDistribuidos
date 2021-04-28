package es.sd.practica1.Repositorios;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Tratamiento;

public interface RepositorioTratamiento extends JpaRepository<Tratamiento,Long>{
    List<Tratamiento> findByOrderByCultivoAplicadoEspecieAsc();
    List<Tratamiento> findByOrderByCultivoAplicadoEspecieDesc();

    Optional<List<Tratamiento>> findByfinReentradaGreaterThan(LocalDate date);
    Optional<List<Tratamiento>> findByfinRecoleccionGreaterThan(LocalDate date);


    
}
