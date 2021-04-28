package es.sd.practica1.Controladores;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.swing.plaf.basic.BasicTreeUI.TreeToggleAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("listaCultivos", servicioCultivos.findAll());
        model.addAttribute("listaProductos", servicioProductos.findAll());
        return "formularioTratamiento";
    }
    
    @PostMapping(value="/nuevoTratamiento")
    public String nuevoTratamiento( String cultivoSeleccionado, String productoSeleccionado, String lote, String fechaInicio,
     String especie, String variedad, String zona,  String fechaPlantado,
     String nombre, String descripcion, int plazoReentrada, int plazoRecoleccion) {
        Tratamiento nuevoTratamiento = new Tratamiento();
        Producto productoAplicado;
        Cultivo cultivoAplicado;
        if(especie.isBlank()){
            cultivoAplicado = servicioCultivos.findByEspecie(cultivoSeleccionado);
        }else{
            cultivoAplicado = new Cultivo(especie,variedad,LocalDate.parse(fechaPlantado),zona);
            servicioCultivos.save(cultivoAplicado);
        }
        if(nombre.isBlank()){
            productoAplicado = servicioProductos.findByNombre(productoSeleccionado);
        }else{
            productoAplicado = new Producto(nombre,descripcion,plazoReentrada,plazoRecoleccion);
            servicioProductos.save(productoAplicado);
        }
        

        nuevoTratamiento.setLote(lote);
        nuevoTratamiento.setFechaInicio(LocalDate.parse(fechaInicio));
        nuevoTratamiento.setCultivoAplicado(cultivoAplicado);
        nuevoTratamiento.setProductoAplicado(productoAplicado);
        nuevoTratamiento.setFinRecoleccion(nuevoTratamiento.getFechaInicio().plusDays(productoAplicado.getPlazoRecoleccion()));
        nuevoTratamiento.setFinReentrada(nuevoTratamiento.getFechaInicio().plusDays(productoAplicado.getPlazoReentrada()));

        servicioTratamientos.save(nuevoTratamiento);
        return "exito";
    }

    @PostMapping(value="/filtrar")
    public String filtarTratamientos(@RequestParam String metodoFiltrado, Model model) {
        List<Tratamiento> tratamientos;
        switch (metodoFiltrado) {
            case "EspecieAsc":
                tratamientos = servicioTratamientos.findAllOrderByEspecieAsc();
                break;
            case "EspecieDes":
                tratamientos = servicioTratamientos.findAllOrderByEspecieDesc();
                break;
            case "FinReentradaAsc":
                tratamientos = servicioTratamientos.findAll(Sort.by(Order.asc("finReentrada")));
                break;
            case "FinReentradaDes":
                tratamientos = servicioTratamientos.findAll(Sort.by(Order.desc("finReentrada")));
                break;
            case "FinRecoleccionAsc":
                tratamientos = servicioTratamientos.findAll(Sort.by(Order.asc("finRecoleccion")));
                break;
            case "FinRecoleccionDes":
                tratamientos = servicioTratamientos.findAll(Sort.by(Order.desc("finRecoleccion")));
                break;
            default:
                tratamientos = servicioTratamientos.findAll();
                break;
        }

        model.addAttribute("listaTratamientos", tratamientos);
        return "tratamientos";
    }
    
   


    @GetMapping("/getTratamientosByDate")
    public String busquedaTratamientoPorFecha(@RequestParam String date, Model model) {

        Optional<List<Tratamiento>> reentrada =  servicioTratamientos.findByfinReentradaGreaterThan(LocalDate.parse(date));
        Optional<List<Tratamiento>> recoleccion =  servicioTratamientos.findByfinRecoleccionGreaterThan(LocalDate.parse(date));
        List<Tratamiento> listacompleta = new ArrayList();
        

        if (reentrada.isPresent()) {
            listacompleta.addAll(reentrada.get());
        }
        if (recoleccion.isPresent()) {
            listacompleta.addAll(recoleccion.get());
        }
       
        model.addAttribute("listaTratamientos", listacompleta);
       
        return "tratamientos";
    }

    
    
}