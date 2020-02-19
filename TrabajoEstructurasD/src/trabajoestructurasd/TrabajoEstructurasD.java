/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dianella
 */
public class TrabajoEstructurasD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListasSimples<Integer> miLista = new ListasSimples<>();
        miLista.addOrderedMin(11);
        miLista.addOrderedMin(33);
        miLista.addOrderedMin(4);
        miLista.addOrderedMin(88);
        miLista.addOrderedMin(99);
        miLista.addOrderedMin(22);
        
        
        System.out.println("La lista ordenada de menor a mayor es: "+miLista.showData());
        System.out.println("La cantidad de nodos de la lista es de "+miLista.quantityData());
        System.out.println("El mayor dato de la lista es: "+miLista.majorData());
        System.out.println("El menor dato de la lista es: "+miLista.minorData());
        System.out.println("El promedio de la lista es: "+miLista.avgList());
        System.out.println("Si el dato existe retorna true sino false "+miLista.exist(31));
        miLista.specificData(32, 33);
        System.out.println(miLista.showData());
        
        
//        try {
//            miLista.deleteSpecific(13);
//        } catch (Exception ex) {
//            Logger.getLogger(TrabajoEstructurasD.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        //System.out.println(miLista.showData());
        
        
        ListasDobles<Integer> myDoublelist = new ListasDobles<>();
        myDoublelist.addOrdered(66);
        myDoublelist.addOrdered(11);
        myDoublelist.addOrdered(99);
        myDoublelist.addOrdered(33);
        myDoublelist.addOrdered(44);
        myDoublelist.addOrdered(22);
        myDoublelist.addOrdered(101);
        
        System.out.println(myDoublelist.showData());
        
        
        try {
            myDoublelist.delete(99);
            
        } catch (Exception ex) {
            Logger.getLogger(TrabajoEstructurasD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(myDoublelist.showData());
        
        try {
            myDoublelist.specificData(44, 45);
            
        } catch (Exception ex) {
            Logger.getLogger(TrabajoEstructurasD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(myDoublelist.showData());
    }
    
}
