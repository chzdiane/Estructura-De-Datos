/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

import java.util.ArrayList;

/**
 *
 * @author samaniw
 */
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    ArrayList<String> levels;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    public void Postorden() {
        Postorden(root);
    }
    
    private void Postorden(BinaryNode currentRoot){
        if(currentRoot != null){
            Postorden(currentRoot.getLeft());
            Postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
    public void PreOrden() {
        PreOrden(root);
    }
    
    private void PreOrden(BinaryNode currentRoot){
        if(currentRoot != null){
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
        }
    }

    //Punto 4
    public int CountNodes() {
        return CountNodes(root);
    }
    
    private int CountNodes(BinaryNode currentRoot){
        int nodes = 0;
        if(currentRoot != null){
            nodes += CountNodes(currentRoot.getLeft());
            nodes += CountNodes(currentRoot.getRight());
            nodes++;
        }
        return nodes;
    }

    //Punto 5
    public int CountLeafs() {
        return CountLeafs(root);
    }
    
    private int CountLeafs(BinaryNode currentRoot){
        if(currentRoot != null){
            if(currentRoot.getLeft() == null && currentRoot.getRight() == null){
                return 1;
            } else {
                return CountLeafs(currentRoot.getLeft()) + CountLeafs(currentRoot.getRight());
            }
        }
        return 0;
    }

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                Add(data, root);

            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data));
            } else {
                Add(data, currentRoot.getLeft());
            }

        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Punto 6
    public void Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {
        BinaryNode node = Search(data);
        if(node != null){
            if(node == this.root && node.isLeaf()) {
                root = null;
            }
            if(node.isLeaf()) {
                if (position) {
                    father.setRight(null);
                }else{
                    father.setLeft(null);
                }
            }else if(node.hasOneChild()) {
                if (node.isChildPosition()) {
                
                    if(root == node){
                        BinaryNode minimum = getMinor(node.getRight());
                        Delete(minimum.getData());
                        node.setData(minimum.getData());
                        minimum.setLevel(node.getLevel());
                    }else if(position){
                        father.setRight(node.getRight());
                    }else{
                        father.setLeft(node.getRight());
                    }
                    node.setRight(null);

                }else{
                    if(root == node){
                        root=node.getLeft();
                        node.setLeft(null);
                    }else if(position){
                        father.setRight(node.getLeft());
                    }else{
                        father.setLeft(node.getLeft());
                    }
                    node.setRight(null);

                }
            }else{
                BinaryNode minimum = getMinor(node.getRight());
                Delete(minimum.getData());
                node.setData(minimum.getData());
                minimum.setLevel(node.getLevel());
            }
        }
    }

    //Punto 7
    public int LastLevel() {
        return (LastLevel(root)-1);
    }
    
    private int LastLevel(BinaryNode currentRoot){
       int lastRight, lastLeft;
       if(currentRoot.getRight() == null){
           lastRight = 0;
       } else {
           lastRight = 1 + LastLevel(currentRoot.getRight());
       }
       if(currentRoot.getLeft() == null){
           lastLeft = 0;
       } else {
           lastLeft = 1 + LastLevel(currentRoot.getLeft());
       }
       return (Math.max(lastRight, lastLeft));
    }

    //Punto 8
    public String LevelOrder() {
        
        levels = new ArrayList<String>();
        LevelOrder(root, 0);
        String text = "";
        for (int i = 0; i < levels.size(); i++) {
            text += (levels.get(i));
            if (i < levels.size() - 1) {
                text += "\n";
            }
        }
        return text;
        
        /* 
        Para mostrar los datos se recomienda usar:
            System.out.print(x.getData()+" ");
        donde x representa un nodo del árbol

        Para generar un salto de linea se recomienda usar:
            System.out.print("\n");
        
         */
    }
    
    private void LevelOrder(BinaryNode currentRoot, int level){
        if (currentRoot != null) {
            LevelOrder(currentRoot.getLeft(), level + 1);
            while (level > (levels.size() - 1)) {
                levels.add("");
            }
            levels.set(level, levels.get(level) + currentRoot.getData() + " ");
            LevelOrder(currentRoot.getRight(), level + 1);
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
}
