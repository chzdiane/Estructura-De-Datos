/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.LinkedList;

/**
 *
 * @author samaniw
 */
public class Graph {

    private boolean aMatrix[][];
    private int totalNodes;
    private LinkedList<Integer> aList[];

    public Graph(int n) {
        totalNodes = n;
        aMatrix = new boolean[n][n];
        aList = new LinkedList[n];
        for (int i = 0; i < totalNodes; i++) {
            aList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        aMatrix[source][destination] = true;
        aList[source].add(destination);
    }

    public void deleteEdge(int source, int destination) {
        aMatrix[source][destination] = false;
        aList[source].remove((Object) destination);
    }

    public String showAMatrix() {
        String Table = "";

        for (int i = 0; i < totalNodes; i++) {
            for (int j = 0; j < totalNodes; j++) {
                Table += aMatrix[i][j] ? 1 : 0;
            }
            Table += "\n";
        }

        return Table;
    }

    public String showAList() {
        String List = "";
        for (int i = 0; i < totalNodes; i++) {
            List += i + ": ";
            for (Integer v : aList[i]) {
                List += v + " ";
            }
            List += "\n";
        }
        return List;
    }

    public void DFS(int source) {
        boolean visited[] = new boolean[totalNodes];
        DFS(source, visited);
    }

    private void DFS(int source, boolean visited[]) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int v : aList[source]) {
            if (!visited[v]) {
                DFS(v, visited);
            }
        }
    }

    public void BFS(int source) {
        boolean visited[] = new boolean[totalNodes];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");
            for (int v : aList[source]) {
                if (!visited[v]) {
                     visited[v] = true;
                     queue.add(v);
                }
            }
        }
    }
    
    public void Tour(int source) {
        LinkedList<Integer> visited = new LinkedList<>();
        for (int i = 0; i < totalNodes; i++) {
            for (int v : aList[i]) {
                if (visited.contains(i)) {
                    System.out.print(v + " ");
                    System.out.print(i + " ");
                } else {
                    visited.add(v);
                }
            }

        }
    }

    private int Input(boolean aMatrix[][], int columna) {
        int entradas = 0;
        for (int i = 0; i < totalNodes; i++) {
            if (aMatrix[i][columna]) {
                entradas++;
            }
        }
        return entradas;
    }

    private int Output(boolean aMatrix[][], int fila) {
        int salidas = 0;
        for (int j = 0; j < totalNodes; j++) {
            if (aMatrix[fila][j]) {
                salidas++;
            }
        }
        return salidas;
    }

    public boolean quantityInputOuput() {
        for (int i = 0; i < totalNodes; i++) {
            if (Input(aMatrix, i) == Output(aMatrix, i)) {
                   return true;
            }
        }
        return false;
    }
    
    public void missingEdge(){
        boolean currentMatrix[][] = aMatrix;
        for(int i = 0; i < totalNodes; i++){
            for(int j = 0; j< totalNodes; j++){
                if(!currentMatrix[i][j] && i!=j){
                    System.out.println(i + "," + j);
                    currentMatrix[j][i] = true;
                }
            }
        }
    }

}
