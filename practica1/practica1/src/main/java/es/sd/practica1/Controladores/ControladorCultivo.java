package es.sd.practica1.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControladorCultivo {

    @GetMapping(value="/")
    public String index(Model model) {
        return "cultivos";
    }

    @GetMapping(value="/cultivos")
    public String cultivos(Model model) {
        return "cultivos";
    }

    @GetMapping(value="/productos")
    public String productos(Model model) {
        return "productos";
    }

    @GetMapping(value="/tratamientos")
    public String tratamientos(Model model) {
        return "tratamientos";
    }
    
}
