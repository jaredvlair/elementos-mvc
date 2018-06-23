/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //controlador mvc con arquitectra rest
@RequestMapping("/api")//api son inciales que es el co tezto general , donde estara todos sus servicios un standar
@CrossOrigin//mantener el origen exclusado , que s econecte a otros servidres remotos 
public class ControladorMensaje {
    
    @Autowired RepositorioMensaje repoMensa;//inopporemenaba los metodos y operaciones 
    /*
    @GetMapping("/hola")
    public String algo(){
        return "Hola mundo de sde un controlador ";
    }*/
     //caso 2 insico a ; buscr todos
    
    @GetMapping("/mensaje")    //porque es el metodo buscar todos , para el get metodo mapeo
    public List<Mensaje> buscarTodos(){
        return repoMensa.findAll();
    }
    //caso b: BUSCAR POR ID
    
    @GetMapping("/mensaje/{id}")
    public Mensaje buscarPorId(@PathVariable String id){
        Mensaje mensa= new Mensaje();
        
        return repoMensa.findById(id).get();
    }
    //para guardar caso c)
    
    @PostMapping ("/mensaje")
    public Estatus guardar(@RequestBody String json ) throws IOException{
    //primero convertimos este string json a un objeto java
    ObjectMapper maper=new ObjectMapper();
  Mensaje mensa=  maper.readValue(json, Mensaje.class);
  //para guaradar esat liena es
  repoMensa.save(mensa);
        System.out.println("este obeto se convirtio"+mensa);
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje ("mensaje guardado con exito!!!!");
        return estatus;//ver que se depure el programa
    }
  
  //caso d: ACTUALIZAR
      
    @PutMapping ("/mensaje")
    public Estatus actualizar(@RequestBody String json ) throws IOException{
    //primero convertimos este string json a un objeto java
    ObjectMapper maper=new ObjectMapper();
  Mensaje mensa=  maper.readValue(json, Mensaje.class);
  //para guaradar esat liena es
  repoMensa.save(mensa);
        System.out.println("este obeto se convirtio"+mensa);
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje ("mensaje guardado con exito!!!!");
        return estatus;//ver que se depure el programa
    }
  //CASO E:BORRAR
      @DeleteMapping("/mensaje/{id}")
    public Estatus borrarPorId(@PathVariable String id){
        Mensaje mensa= new Mensaje();
        
        repoMensa.deleteById(id);
        Estatus e=new Estatus();
        e.setSuccess(true);
        e.setMensaje("Mensaje borrado con exito");
        return e;
    }
}
