package es.sd.practica1.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Tratamiento;

public interface RepositorioTratamiento extends JpaRepository<Tratamiento,Long>{
    List<Tratamiento> findByOrderByCultivoAplicadoEspecieAsc();
    List<Tratamiento> findByOrderByCultivoAplicadoEspecieDesc();
    
    /*List<Tratamiento>findAllOrderByFinReentradaAsc();
    List<Tratamiento>findAllOrderByFinReentradaDesc();
    List<Tratamiento>findAllOrderByFinRecoleccionAsc();
    List<Tratamiento>findAllOrderByFinRecoleccionDesc();*/
}
