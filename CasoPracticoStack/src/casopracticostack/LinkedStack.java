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
public class LinkedStack<E> {
    
    private Node<E> top, tail, root;
    private int sizeStack;

    public LinkedStack() {
        top = null;
        tail = null;
        root = new Node<>((E) "raiz");
        sizeStack = 0;
    }

    
    public boolean empty() {
        return top == null && tail == null;
    }

    
    public E peek() {
        return (empty()) ? null : top.getData();
    }

    public E pop() {
        if (empty()) {
            return null;
        } else {
            E dataTemp = top.getData();
            top = (top.getNextNode() == null) ? null : top.getNextNode();
            sizeStack--;
            return dataTemp;
        }
    }

    public E pop1() {
        
        if (top == null) {
            return null;
        } else {
            E dataTemp = top.getData();
            top = (top.getNextNode() == root) ? null : top.getNextNode();
            sizeStack--;
            return dataTemp;
        }
    }

    public E pop2() {
        if (tail == null) {
            return null;
        } else {
            E dataTemp = tail.getData();
            tail = (tail.getNextNode() == root) ? null : tail.getNextNode();
            sizeStack--;
            return dataTemp;
        }
    }

    
    public E push(E item) {
        sizeStack++;
        top = new Node<E>(item, top);
        return item;
    }

    public E push1(E item) {
        if (top == null) {
            top = new Node<E>(item, root);
        } else {
            top = new Node<E>(item, top);
        }
        sizeStack++;
        return item;
    }

    public E push2(E item) {
        if (tail == null) {
            tail = new Node<E>(item, root);
        } else {
            tail = new Node<E>(item, tail);
        }
        sizeStack++;
        return item;
    }

    public int search(E o) {
        Node<E> current = this.top;
        int posicion = 1;
        while (current != null) {
            if (this.top.getData().equals(o)) {
                return posicion;
            } else if (current.getData().equals(o)) {
                return posicion;
            } else {
                current = current.getNextNode();
                posicion++;
            }
        }
        return -1;
    }

    public Node<E> getTop() {
        return this.top;
    }
}
