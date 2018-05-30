package unitec.elementosmvc;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosMvcApplication implements CommandLineRunner{
    
    @Autowired ServicioTarjeta servicio;
    @Autowired RepositorioMensaje repoMensaje;

	public static void main(String[] args) {
		SpringApplication.run(ElementosMvcApplication.class, args);
                
               
	}

    @Override
    public void run(String... args) throws Exception { 
       /*
        servicio.obtenerSaldo().obtenerSaldo();
       
        LocalDate fecha=LocalDate.now();
      
        //repoMensaje.save(new Mensaje("HOAL",fecha, "cerdito "));
       
       //buscar todos los mensajes
       /* @Override
    public String toString() {
        return "Mensaje{" + "id=" + id + ", fecha=" + fecha + ", cuerpo=" + cuerpo + '}';
    }

       for (Mensaje  mensa: repoMensaje.findAll()){
           System.out.println(mensa);
           
       }
     
     //buscar por id
    
      // System.out.println(repoMensaje.findById("5b08c8ec12ab6e033438c60e").get());
        
        System.out.println(repoMensaje.findByCuerpo("cerdito")); 
        
        //borrar
        Mensaje m=new Mensaje();
        m.setId("hoal");
        repoMensaje.delete(m );
     */   
       
    }
}
