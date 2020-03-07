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

        System.out.println("La lista ordenada de menor a mayor es: " + miLista.showData());
        System.out.println("La cantidad de nodos de la lista es de " + miLista.quantityData());
        System.out.println("El mayor dato de la lista es: " + miLista.majorData());
        System.out.println("El menor dato de la lista es: " + miLista.minorData());
        System.out.println("El promedio de la lista es: " + miLista.avgList());
        System.out.println("Si el dato existe retorna true sino false " + miLista.exist(31));
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

        ListasCircularesSimples<Integer> myCSL = new ListasCircularesSimples<>();

        try {
            myCSL.addOrdered(88);
            myCSL.addOrdered(99);
            myCSL.addOrdered(77);
            myCSL.addOrdered(66);
            myCSL.addOrdered(55);

        } catch (Exception ex) {
            Logger.getLogger(TrabajoEstructurasD.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("LISTA CIRCULAR SIMPLE ORDENADA DE MAYOR A MENOR: " + myCSL.showData());
        System.out.println("Recorrido desde un nodo especifico " + myCSL.toGoSpecifycData(77));

        ListasCircularesDobles<Integer> myCDL = new ListasCircularesDobles<>();

        try {
            myCDL.addOrdered(99);
            myCDL.addOrdered(88);
            myCDL.addOrdered(77);
            myCDL.addOrdered(66);
            myCDL.addOrdered(55);

        } catch (Exception ex) {
            Logger.getLogger(TrabajoEstructurasD.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("LA LISTA CIRCULAR DOBLE ORDENADA DE MENOR A MAYOR: " + myCDL.showData());
        System.out.println("El metodo retorna true si el dato existe sino retorna false -> " + myCDL.exist(55));

        try {
            ListasCircularesDobles<Integer> newList = myCDL.divideList(99);
            System.out.println("La Nueva lista: " + myCDL.showData());
        } catch (Exception ex) {
            Logger.getLogger(ListasCircularesDobles.class.getName()).log(Level.SEVERE, null, ex);
        }

        Validate exp = new Validate();

        System.out.println("Balanceado: " + exp.checkParanthesisBalanced("{[(5+5)}]"));
        System.out.println("Balanceado: " + exp.checkParanthesisBalanced("{2[1-(5+5)/5]*4}"));
        System.out.println("");

        ConvertBase data = new ConvertBase();
        try {
            System.out.println(data.toBase("16", 13290000));
            System.out.println(data.toBase("8", 2002));
            System.out.println(data.toBase("3", 150));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        LinkedQueue<Object> cola = new LinkedQueue<>();
        System.out.println("");
        System.out.println("add: " + cola.add(1));
        System.out.println("add:" + cola.add(2));
        System.out.println("add:" + cola.offer(3));
        System.out.println("add:" + cola.offer(4));
        System.out.println("");

        try {
            System.out.println("remove: " + cola.remove());
            System.out.println("remove: " + cola.remove());
            System.out.println("remove: " + cola.remove());
            System.out.println("remove: " + cola.remove());
            System.out.println("remove: " + cola.remove());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);

        System.out.println("");
        System.out.println("poll: " + cola.poll());
        System.out.println("poll: " + cola.poll());
        System.out.println("poll: " + cola.poll());
        System.out.println("poll: " + cola.poll());
        System.out.println("poll: " + cola.poll());
        System.out.println("");

        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);

        try {
            System.out.println("element: " + cola.element());
            cola.remove();
            cola.remove();
            cola.remove();
            cola.remove();
            System.out.println("element: " + cola.element());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("");
        cola.add(1);
        cola.add(2);
        System.out.println("peek: " + cola.peek());
        try {
            cola.remove();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("peek: " + cola.peek());
        try {
            cola.remove();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("peek: " + cola.peek());
    }

}
