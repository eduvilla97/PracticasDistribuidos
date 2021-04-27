package es.sd.practica1.Servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sd.practica1.Entidades.Tratamiento;
import es.sd.practica1.Repositorios.RepositorioTratamiento;

@Service
public class ServicioTratamiento {
    @Autowired
    private RepositorioTratamiento repositorio;

    public void save(Tratamiento nuevoTratamiento) {
        repositorio.save(nuevoTratamiento);
    }

    public List<Tratamiento> findAll() {
        return repositorio.findAll();
    }

    public Optional<Tratamiento> searchByDate( LocalDate fechainicio,LocalDate fechafinal) {
        //Optional<List<Tratamiento>> initDATE = repositorio.findFecha(fechainicio, fechafinal);
        return repositorio.findByfechaInicioBetween(fechainicio, fechafinal);
        //return repositorio.findByfechaInicioLessThanEqualAndfinReentradaGreaterThanEqual(fechainicio, fechafinal);
    }
    
}
