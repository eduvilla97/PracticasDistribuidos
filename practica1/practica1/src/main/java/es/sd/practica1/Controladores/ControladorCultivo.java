package es.sd.practica1.Controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.sd.practica1.Entidades.Cultivo;
import es.sd.practica1.Servicios.ServicioCultivo;





@Controller
public class ControladorCultivo {
    @Autowired
    private ServicioCultivo cultivos;


    @GetMapping(value="/")
    public String index(Model model) {

        model.addAttribute("listaCultivos", cultivos.findAll());

        return "cultivos";
    }


    @GetMapping(value="/cultivos")
    public String cultivos(Model model) {
        model.addAttribute("listaCultivos", cultivos.findAll());
        return "cultivos";
    }

    @GetMapping(value="/editarCultivo/{id}")
    public String editarCultivo(@PathVariable Long id, Model model) {
        Cultivo micultivo = cultivos.findById(id);
        model.addAttribute("cultivo", micultivo);
        return "editarcultivo";
    }


    @RequestMapping(value="/modifyCultivo/{id}", method=RequestMethod.GET)
    public String modifycultivo(@PathVariable Long id, String especie, String variedad, String zona, String fechaPlantado) {
        Cultivo nuevoCultivo = cultivos.findById(id);
        nuevoCultivo.setEspecie(especie);
        nuevoCultivo.setVariedad(variedad);
        nuevoCultivo.setZona(zona);
        nuevoCultivo.setFechaPlantado(LocalDate.parse(fechaPlantado));
        cultivos.save(nuevoCultivo);
        return "exitomodificacion";
    }

    
    @GetMapping(value="/formularioNuevoCultivo")
    public String formularioNuevoCultivo(Model model) {
        return "formularioCultivo";
    }

    @RequestMapping(value="/addNuevoCultivo", method=RequestMethod.POST)
    public String addNuevoCultivo(Model model,String especie, String variedad, String zona, String fechaPlantado) {
        Cultivo nuevoCultivo = new Cultivo();
        nuevoCultivo.setEspecie(especie);
        nuevoCultivo.setVariedad(variedad);
        nuevoCultivo.setZona(zona);
        nuevoCultivo.setFechaPlantado(LocalDate.parse(fechaPlantado));
        cultivos.save(nuevoCultivo);
        return "exito";
    }
    
    
    

    
}
