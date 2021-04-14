package es.sd.practica1.Servicios;

import java.util.List;

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
    
}
