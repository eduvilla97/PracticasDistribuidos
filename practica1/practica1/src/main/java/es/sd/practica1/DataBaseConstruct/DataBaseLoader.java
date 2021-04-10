package es.sd.practica1.DataBaseConstruct;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import es.sd.practica1.Entidades.Cultivo;
import es.sd.practica1.Entidades.Producto;
import es.sd.practica1.Entidades.Tratamiento;
import es.sd.practica1.Repositorios.RepositorioCultivo;
import es.sd.practica1.Repositorios.RepositorioProducto;
import es.sd.practica1.Repositorios.RepositorioTratamiento;

public class DataBaseLoader {
   
    

    @Autowired
    RepositorioCultivo RepositorioCultivo;

    @Autowired
    RepositorioProducto repositorioProducto;

    @Autowired
    RepositorioTratamiento RepositorioTratamiento;

    @PostConstruct
    private void initDataBase(){
        LocalDate localDate = LocalDate.now();


        Cultivo Margarita = new Cultivo("Margarita","Amarilla",localDate,"España");
        Cultivo Rosa = new Cultivo("Rosa","Roja",localDate,"España");
        Cultivo Clavel = new Cultivo("Clavel","Amarilla",localDate,"España");
        Cultivo Crisantemo = new Cultivo("Crisantemo","Azul",localDate,"España");
        Cultivo RosaNegra = new Cultivo("Rosa","Negra",localDate,"España");
        Cultivo Tulipan = new Cultivo("Tulipan","Amarillo",localDate,"España");



        Producto amoxicilina = new Producto("amoxicilina","protege la planta",19,22);
        Producto dalsy = new Producto("dalsy","protege la planta",19,22);
        Producto apiretal = new Producto("apiretal","protege la planta",19,22);
        Producto ibuprofeno = new Producto("ibuprofeno","protege la planta",19,22);


        Tratamiento tratamiento =  new Tratamiento(Margarita,amoxicilina,"Panama",localDate,localDate,localDate);
        Tratamiento tratamiento2 =  new Tratamiento(Margarita,dalsy,"Panama",localDate,localDate,localDate);
        Tratamiento tratamiento3 =  new Tratamiento(Rosa,amoxicilina,"Panama",localDate,localDate,localDate);
        Tratamiento tratamiento5 =  new Tratamiento(Clavel,apiretal,"Panama",localDate,localDate,localDate);
        Tratamiento tratamiento6 =  new Tratamiento(Clavel,amoxicilina,"Panama",localDate,localDate,localDate);
        Tratamiento tratamiento7 =  new Tratamiento(RosaNegra,ibuprofeno,"Panama",localDate,localDate,localDate);
        Tratamiento tratamiento8 =  new Tratamiento(Tulipan,ibuprofeno,"Panama",localDate,localDate,localDate);


        RepositorioCultivo.save(Margarita);
        RepositorioCultivo.save(Rosa);
        RepositorioCultivo.save(Clavel);
        RepositorioCultivo.save(Crisantemo);
        RepositorioCultivo.save(RosaNegra);
        RepositorioCultivo.save(Tulipan);

        repositorioProducto.save(amoxicilina);
        repositorioProducto.save(dalsy);
        repositorioProducto.save(apiretal);
        repositorioProducto.save(ibuprofeno);

        RepositorioTratamiento.save(tratamiento);
        RepositorioTratamiento.save(tratamiento2);
        RepositorioTratamiento.save(tratamiento3);
        RepositorioTratamiento.save(tratamiento5);
        RepositorioTratamiento.save(tratamiento8);
        RepositorioTratamiento.save(tratamiento6);
        RepositorioTratamiento.save(tratamiento7);

    }

}
