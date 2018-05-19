/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
/**
 *
 * @author Jared
 */

@SpringUI
public class MiUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
//poner el orden de arriba a abajo 

        VerticalLayout layout=new VerticalLayout();
        Label etiqueta=new Label("bienvenido a mi aplicacion"); 
        etiqueta.addStyleName(ValoTheme.LABEL_H2);
        
        Button boton=new Button("Ingresasr!!");
        boton.addStyleName(ValoTheme.BUTTON_DANGER);
        //agregamos la etiueta y el boton a el layout 
        layout.addComponent(etiqueta);
        layout.addComponent(boton);
        
        //finalmente agregamos el layout al contenedor principal de init
        setContent(layout);
    }
    
}
