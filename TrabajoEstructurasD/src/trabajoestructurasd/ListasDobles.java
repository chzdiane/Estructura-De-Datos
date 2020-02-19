/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

import java.util.HashSet;

/**
 *
 * @author Dianella
 */
public class ListasDobles<T extends Comparable> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public ListasDobles() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String showData() {
        String data = "";
        DoubleNode<T> current = this.head;
        while (current != null) {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }
        return data;
    }

    public void add(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            head = new DoubleNode<>(d, null, head);
            head.getNextNode().setPreviousNode(head);
        }
    }

    public boolean serchData(T d) {

        DoubleNode<T> current = this.head;
        while (current != null) {
            if (current.getData() == d) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    public void addLast(T d) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(d);
        } else {
            tail = new DoubleNode<>(d, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
    }

    public void addOrdered(T d) {
        if (isEmpty() || d.compareTo(head.getData()) == 1) {
            add(d);
            return;
        }
        if (isEmpty() || d.compareTo(tail.getData()) == -1) {
            addLast(d);
            return;
        }

        DoubleNode<T> current = head.getNextNode();
        DoubleNode<T> newNode;

        while (current.getData().compareTo(d) == 1) {
            current = current.getNextNode();
        }

        newNode = new DoubleNode<>(d, current.getPreviousNode(), current);
        current.getPreviousNode().setNextNode(newNode);
        current.setPreviousNode(newNode);
    }

    public void delete(T d) throws Exception {

        DoubleNode<T> current = this.head;

        if (isEmpty()) {
            throw new Exception("La lista ya esta vacia ");
        } else {
            while (current != null) {
                if (current.getData().compareTo(d) == 0) {
                    current.getPreviousNode().setNextNode(current.getNextNode());
                    current.getNextNode().setPreviousNode(current.getPreviousNode());
                }

                current = current.getNextNode();
            }

        }
    }
    
    public boolean exist(T d){
        DoubleNode<T> current = head;
        while(current != null){
            if(current.getData().compareTo(d) == 0){
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    public void specificData(T data, T newData) throws Exception {        
        if(isEmpty()){
            throw new Exception("La lista esta vacia");
        } else {
            if(!exist(data)){
                throw new Exception("El dato no es encuentra en la lista");
            } else {
                DoubleNode<T> current = this.head;
                while (current != null) {
                    if(current.getData().compareTo(data) == 0){
                       if (current.getNextNode() != null) {
                            DoubleNode<T> newNode = new DoubleNode<>(newData, current, current.getNextNode());
                            current.setNextNode(newNode);
                            current.getNextNode().setPreviousNode(newNode);
                        } else {
                           addLast(newData);
                       }
                    }
                    current = current.getNextNode();
                }
            }
        }
    }
}
