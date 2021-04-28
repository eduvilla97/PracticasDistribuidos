package es.sd.practica1.DataBaseConstruct;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sd.practica1.Entidades.Cultivo;
import es.sd.practica1.Entidades.Producto;
import es.sd.practica1.Entidades.Tratamiento;
import es.sd.practica1.Repositorios.RepositorioCultivo;
import es.sd.practica1.Repositorios.RepositorioProducto;
import es.sd.practica1.Repositorios.RepositorioTratamiento;

@Component
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
        LocalDate localDate2 = localDate.plusDays(3);
        LocalDate localDate3 = localDate.plusDays(6);
        LocalDate localDate4 = localDate.plusDays(8);

        Cultivo Margarita = new Cultivo("Margarita","Amarilla",localDate,"Espana");
        Cultivo Rosa = new Cultivo("Rosa","Roja",localDate,"España");
        Cultivo Clavel = new Cultivo("Clavel","Amarilla",localDate,"Espana");
        Cultivo Crisantemo = new Cultivo("Crisantemo","Azul",localDate,"Espana");
        Cultivo RosaNegra = new Cultivo("Rosa","Negra",localDate,"Espana");
        Cultivo Tulipan = new Cultivo("Tulipan","Amarillo",localDate,"Espana");



        Producto amoxicilina = new Producto("Amoxicilina","protege la planta",19,22);
        Producto dalsy = new Producto("Dalsy","protege la planta",19,22);
        Producto apiretal = new Producto("Apiretal","protege la planta",19,22);
        Producto ibuprofeno = new Producto("Ibuprofeno","protege la planta",19,22);


        Tratamiento tratamiento =  new Tratamiento(Margarita,amoxicilina,"Panama",localDate,localDate2,localDate4);
        Tratamiento tratamiento2 =  new Tratamiento(Margarita,dalsy,"Panama",localDate,localDate3,localDate2);
        Tratamiento tratamiento3 =  new Tratamiento(Rosa,amoxicilina,"Panama",localDate,localDate2,localDate3);
        Tratamiento tratamiento5 =  new Tratamiento(Clavel,apiretal,"Panama",localDate,localDate,localDate4);
        Tratamiento tratamiento6 =  new Tratamiento(Clavel,amoxicilina,"Panama",localDate,localDate2,localDate3);
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
