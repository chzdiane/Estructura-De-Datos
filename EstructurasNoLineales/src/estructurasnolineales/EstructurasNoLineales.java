/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
public class EstructurasNoLineales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DGrahp g0 = new DGrahp();
        g0.addNode("A");
        g0.addNode("D");
        g0.addNode("B");
        g0.addNode("C");
        g0.addNode("E");
        g0.addEdge("A", "B", 1);
        g0.addEdge("A", "C", 1);
        g0.addEdge("A", "E", 3);
        g0.addEdge("C", "E", 1);
        
        g0.showAList();
        Graph g1 = new Graph(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(3, 6);
        g1.addEdge(4, 6);
        g1.addEdge(4, 5);

        //...
//        g1.deleteEdge(0, 1);
//        g1.deleteEdge(1, 2);
        System.out.println("Matriz de adyacencias");
        System.out.println(g1.showAMatrix());
        System.out.println("Lista de adyacencias");
        System.out.println(g1.showAList());

        System.out.println("Recorrido en profundidad");
        g1.DFS(0);
        System.out.println("");
        System.out.println("Recorrido en anchura");
        g1.BFS(0);
        System.out.println("");
        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
        maxData.insert(31);
        maxData.insert(51);
        maxData.insert(53);
        maxData.insert(28);
        maxData.insert(47);
        maxData.insert(22);
        System.out.println(maxData.getDataHeap());
        maxData.ExtractMax();
        System.out.println(maxData.getDataHeap());
        
        System.out.println("ARBOLES BINARIOS");
        System.out.println("");
        
        BinarySearchTree test = new BinarySearchTree(10);
        try {
            test.Add(5);
            test.Add(3);
            test.Add(8);
            test.Add(20);
            test.Add(7);
            test.Add(18);
            test.Add(25);
            test.Add(23);
            test.Add(30);
            test.Add(21);
            test.Add(24);
            System.out.print("Inorden: ");
            test.InOrden(); 
            System.out.println("");
            System.out.print("PreOrden: ");
            test.PreOrden();
            System.out.println("");
            System.out.print("PosOrden: ");
            test.Postorden();
            System.out.println("");
            System.out.println("El total de nodos es: " + test.CountNodes());
            System.out.println("El total de hojas es: " + test.CountLeafs());
            System.out.print("Nodos en el último nivel: " + test.LastLevel());
            System.out.println("");
            System.out.println("Imprimir según el nivel: ");
            test.LevelOrder();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        BinarySearchTree pino = new BinarySearchTree(8);
//        try {
//            pino.Add(3);
//            pino.Add(9);
//            pino.InOrden();
//            pino.Delete(3);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("");
//
//        pino.InOrden();
        
        //System.out.println(pino.Search(88));
    }

}
