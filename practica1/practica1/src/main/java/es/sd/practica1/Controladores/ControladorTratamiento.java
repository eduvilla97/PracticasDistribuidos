package es.sd.practica1.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorTratamiento {

    @GetMapping(value="/tratamientos")
    public String tratamientos(Model model) {
        return "tratamientos";
    }
    
}
