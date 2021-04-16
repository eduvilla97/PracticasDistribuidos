package es.sd.practica1.Controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import es.sd.practica1.Entidades.Cultivo;
import es.sd.practica1.Entidades.Producto;
import es.sd.practica1.Entidades.Tratamiento;
import es.sd.practica1.Servicios.ServicioCultivo;
import es.sd.practica1.Servicios.ServicioProducto;
import es.sd.practica1.Servicios.ServicioTratamiento;


@Controller
public class ControladorTratamiento {
    
    @Autowired
    private ServicioCultivo servicioCultivos;
    @Autowired
    private ServicioProducto servicioProductos;
    @Autowired
    private ServicioTratamiento servicioTratamientos;

    @ModelAttribute
    private void m(Model model) {
        model.addAttribute("vieneDeCrearUnTratamiento", false);
    }

    @GetMapping(value="/tratamientos")
    public String tratamientos(Model model) {
        model.addAttribute("listaTratamientos", servicioTratamientos.findAll());
        return "tratamientos";
    }

    @GetMapping(value="/editarTratamiento/{id}")
    public String formularioEditarTratamiento(@PathVariable Long id) {
        return new String();
    }

    @GetMapping(value="/formularioNuevoTratamiento")
    public String formularioNuevoTratamiento(Model model) {
        model.addAttribute("vieneDeCrearUnTratamiento", true);
        model.addAttribute("listaCultivos", servicioCultivos.findAll());
        model.addAttribute("listaProductos", servicioProductos.findAll());
        return "formularioTratamiento";
    }
    
    @PostMapping(value="/nuevoTratamiento")
    public String nuevoTratamiento(@RequestBody String cultivo, @RequestBody String producto, @RequestBody String lote,@RequestBody String fechaInicio) {
        Tratamiento nuevoTratamiento = new Tratamiento();
        Producto productoAplicado = servicioProductos.findByNombre(producto);
        Cultivo cultivoAplicado = servicioCultivos.findByEspecie(cultivo);

        nuevoTratamiento.setLote(lote);
        nuevoTratamiento.setFechaInicio(LocalDate.parse(fechaInicio));
        nuevoTratamiento.setCultivoAplicado(cultivoAplicado);
        nuevoTratamiento.setProductoAplicado(productoAplicado);
        nuevoTratamiento.setFinRecoleccion(nuevoTratamiento.getFechaInicio().plusDays(productoAplicado.getPlazoRecoleccion()));
        nuevoTratamiento.setFinReentrada(nuevoTratamiento.getFechaInicio().plusDays(productoAplicado.getPlazoReentrada()));

        servicioTratamientos.save(nuevoTratamiento);
        return "exito";
    }
    
    
}