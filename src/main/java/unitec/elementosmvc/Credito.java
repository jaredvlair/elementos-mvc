/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

/**
 *
 * @author Jared
 */
public class Credito implements Tarjeta{

    @Override
    public void obtenerSaldo() {
        System.out.println("Tu credito es de 300,0000");
    }
    
}
