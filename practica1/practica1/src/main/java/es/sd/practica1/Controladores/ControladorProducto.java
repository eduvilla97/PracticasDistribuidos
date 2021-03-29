package es.sd.practica1.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorProducto {

    @GetMapping(value="/productos")
    public String productos(Model model) {
        return "productos";
    }
    
}