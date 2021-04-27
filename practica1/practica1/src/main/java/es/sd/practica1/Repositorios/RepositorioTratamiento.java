package es.sd.practica1.Repositorios;

import java.util.List;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.sd.practica1.Entidades.Tratamiento;

public interface RepositorioTratamiento extends JpaRepository<Tratamiento,Long>{
    List<Tratamiento> findByOrderByCultivoAplicadoEspecieAsc();
    List<Tratamiento> findByOrderByCultivoAplicadoEspecieDesc();

    //Tratamiento findByfechaInicioLessThanEqualAndfinReentradaGreaterThanEqual(LocalDate fechainicio, LocalDate fechafinal);
    

    Optional<Tratamiento> findByfechaInicioBetween(LocalDate fechaInicio, LocalDate fechaFinal);


    /*Optional<List<Tratamiento>> findFecha(LocalDate fechaIn, LocalDate fechaFin) {
        this.fileRepository.find({
            where: { 
                fechaInicio:  MoreThan(fechaIn) ,
                finReentrada:  MoreThan(fechaFin) },
         });
    }*/
    
    /*List<Tratamiento>findAllOrderByFinReentradaAsc();
    List<Tratamiento>findAllOrderByFinReentradaDesc();
    List<Tratamiento>findAllOrderByFinRecoleccionAsc();
    List<Tratamiento>findAllOrderByFinRecoleccionDesc();*/
}
