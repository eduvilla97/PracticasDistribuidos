package es.sd.practica1.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sd.practica1.Entidades.Cultivo;
import es.sd.practica1.Repositorios.RepositorioCultivo;

@Service
public class ServicioCultivo {
    @Autowired
    private RepositorioCultivo repositorio;

    public void save(Cultivo nuevoCultivo) {
        repositorio.save(nuevoCultivo);
    }

    public List<Cultivo> findAll() {
        return repositorio.findAll();
    }

    public Cultivo findById(long id){
        Optional<Cultivo> cultivoInBd = repositorio.findById(id);
        if (cultivoInBd.isPresent()) return cultivoInBd.get();
        else return null;
    }

    public Cultivo findByEspecie(String especie) {
        return repositorio.findByEspecie(especie);
    }
    
}
