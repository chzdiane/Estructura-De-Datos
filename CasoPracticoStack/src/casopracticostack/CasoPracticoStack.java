/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticostack;

/**
 *
 * @author Dianella
 */
public class CasoPracticoStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayStack arregloPilas = new ArrayStack(8);
        ArrayStack arregloPilas2 = new ArrayStack(2);
        arregloPilas2.push1(2);
        arregloPilas2.push1(4);

        System.out.println("Push 1:");
        System.out.println(arregloPilas.push1(2));
        System.out.println(arregloPilas.push1(3));
        System.out.println(arregloPilas.push1(2));
        System.out.println(arregloPilas.push1(3));
        System.out.println(arregloPilas.push1(4));
        System.out.println("");
        System.out.println("Push 2:");
        System.out.println(arregloPilas.push2(5));
        System.out.println(arregloPilas.push2(4));
        System.out.println(arregloPilas.push2(8));
        System.out.println(arregloPilas.push2(8));

        System.out.println("");

        System.out.println("Pop 1:");
        System.out.println(arregloPilas.pop1());
        System.out.println(arregloPilas.pop1());
        System.out.println(arregloPilas.pop1());
        System.out.println("Pop 2:");
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());
        System.out.println(arregloPilas.pop2());

        System.out.println("");

        System.out.println("Arreglo 1 lleno: " + arregloPilas.isFull());
        System.out.println("Arreglo 2 lleno: " + arregloPilas2.isFull());

        System.out.println("");

        System.out.println("BONUS: Pilas enlazadas");
        System.out.println("");

        LinkedStack pilaEnlazada = new LinkedStack();

        System.out.println("Push 1:");
        System.out.println(pilaEnlazada.push1(2));
        System.out.println(pilaEnlazada.push1(3));
        System.out.println(pilaEnlazada.push1(1));

        System.out.println("");

        System.out.println("Push 2:");
        System.out.println(pilaEnlazada.push2(6));
        System.out.println(pilaEnlazada.push2(2));
        System.out.println(pilaEnlazada.push2(9));

        System.out.println("");

        System.out.println("Pop 1:");
        System.out.println(pilaEnlazada.pop1());
        System.out.println(pilaEnlazada.pop1());
        System.out.println(pilaEnlazada.pop1());
        System.out.println(pilaEnlazada.pop1());

        System.out.println("");

        System.out.println("Pop 2:");
        System.out.println(pilaEnlazada.pop2());
        System.out.println(pilaEnlazada.pop2());

        System.out.println("");
    }
    
}
