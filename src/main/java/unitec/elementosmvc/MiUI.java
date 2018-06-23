/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Jared
 */

@SpringUI
public class MiUI extends UI {
   // PONEMOS COMO ATRIBUTO EL REPO
    @Autowired RepositorioMensaje repoMensa;

    @Override
    protected void init(VaadinRequest request) {
//poner el orden de arriba a abajo 

        VerticalLayout layout=new VerticalLayout();
        Label etiqueta=new Label("bienvenido a mi aplicacion"); 
        etiqueta.addStyleName(ValoTheme.LABEL_H2);
        
        //METER CAMPO DE TEXTO
        TextField texto=new TextField();
        texto.setPlaceholder("CUERPO MENSAJE");
        Button boton=new Button("GUARDAR MENSAJE");
        boton.addStyleName(ValoTheme.BUTTON_DANGER);
        
        //MANEJAMOS EL EVENTGO DE TIPO BOTON
        boton.addClickListener(algo->{
            String cuerpo= texto.getValue();//variable local
            //guardamos 
            repoMensa.save(new Mensaje(cuerpo));
            //le comunicamos al usuario un mensajito que se guardo
            Notification.show("MENSAJE GUARDADO", Notification.Type.ERROR_MESSAGE);
             }
        );
        
        //CASO:BUSCAR TODOS
        Grid<Mensaje> grid = new Grid<>();
       
        grid.setItems(repoMensa.findAll());

     grid.addColumn(Mensaje::getId).setCaption("id");
     grid.addColumn(Mensaje::getCuerpo).setCaption("cuerpo");
    
        
        //agregamos la etiueta y el boton a el layout 
        layout.addComponent(etiqueta);
        layout.addComponent(boton);
        layout.addComponent(texto);
        
        //AGREGAMOS DICHA COMPONENTE A NUESTR LAYOUT
        
        layout.addComponent(grid);
        //finalmente agregamos el layout al contenedor principal de init
        setContent(layout);
    }
    
}
