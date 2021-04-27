package es.sd.practica1.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    
    public List<Tratamiento>findAllOrderByEspecieAsc(){
        return repositorio.findByOrderByCultivoAplicadoEspecieAsc();
    }
    public List<Tratamiento>findAllOrderByEspecieDesc(){
        return repositorio.findByOrderByCultivoAplicadoEspecieDesc();
    }
    /*
    public List<Tratamiento>findAllOrderByFinReentradaAsc(){
        return repositorio.findAllOrderByFinReentradaAsc();
    }
    public List<Tratamiento>findAllOrderByFinReentradaDesc(){
        return repositorio.findAllOrderByFinReentradaDesc();
    }
    public List<Tratamiento>findAllOrderByFinRecoleccionAsc(){
        return repositorio.findAllOrderByFinRecoleccionAsc();
    }
    public List<Tratamiento>findAllOrderByFinRecoleccionDesc(){
        return repositorio.findAllOrderByFinRecoleccionDesc();
    }*/

    public List<Tratamiento> findAll(Sort by) {
        return repositorio.findAll(by);
    }
}
