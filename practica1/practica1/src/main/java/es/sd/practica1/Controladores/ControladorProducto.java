package es.sd.practica1.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.sd.practica1.Entidades.Producto;
import es.sd.practica1.Servicios.ServicioProducto;

@Controller
public class ControladorProducto {
    @Autowired
    private ServicioProducto productoServicio;

    @GetMapping(value="/productos")
    public String cultivos(Model model) {
        model.addAttribute("listaProductos", productoServicio.findAll());
        return "productos";
    }

    @GetMapping(value="/editarProducto/{id}")
    public String editarCultivo(@PathVariable Long id, Model model) {
        Producto miproducto = productoServicio.findById(id);
        model.addAttribute("producto", miproducto);
        return "editarproducto";
    }

    @RequestMapping(value="/modifyProducto/{id}", method=RequestMethod.GET)
    public String editarProducto(@PathVariable Long id, String nombre, String descripcion, int plazoReentrada, int plazoRecoleccion) {
        Producto producto = productoServicio.findById(id);
        String strplazoReentrada= String.valueOf(plazoReentrada);
        String strplazoRecoleccion =  String.valueOf(plazoRecoleccion);
        if(nombre!= null){
            producto.setNombre(nombre);
        }
        producto.setDescripcion(descripcion);

        if(strplazoReentrada.isBlank()){
            producto.setPlazoReentrada(0);
        }else{
            producto.setPlazoReentrada(plazoReentrada);
        }

        if(strplazoRecoleccion.isBlank()){
            producto.setPlazoRecoleccion(0);
        }else{
           producto.setPlazoRecoleccion(plazoRecoleccion);
        }    
        productoServicio.save(producto);
        return "exitomodificacion";
    }

    @GetMapping(value="/formularioNuevoProducto")
    public String formularioNuevoProducto(Model model) {
        return "formularioProducto";
    }

    @RequestMapping(value="/addNuevoProducto", method=RequestMethod.POST)
    public String addNuevoProducto(String nombre, String descripcion, int plazoReentrada, int plazoRecoleccion) {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setDescripcion(descripcion);
        nuevoProducto.setPlazoReentrada(plazoReentrada);
        nuevoProducto.setPlazoRecoleccion(plazoRecoleccion);
        productoServicio.save(nuevoProducto);
        return "exito";
    }
}