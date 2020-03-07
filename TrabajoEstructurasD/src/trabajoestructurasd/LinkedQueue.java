/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

import java.util.NoSuchElementException;

/**
 *
 * @author Dianella
 */
public class LinkedQueue<E> {
    
    private DoubleNode<E> head, tail;
    private int sizeQueue;

    public LinkedQueue() {
        head = tail = null;
        sizeQueue = 0;
    }

    public boolean add(E e) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(e);
        } else {
            tail = new DoubleNode<>(e, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
        sizeQueue++;
        return true;
    }

    public boolean offer(E e) {
        if (isEmpty()) {
            head = tail = new DoubleNode<>(e);
        } else {
            tail = new DoubleNode<>(e, tail, null);
            tail.getPreviousNode().setNextNode(tail);
        }
        sizeQueue++;
        return true;
    }

    public E remove() throws Exception {
        if(isEmpty()){
            throw new Exception("\033[031mError: \033[030mNo hay datos por borrar");
        }else{
            DoubleNode<E> aux = head;
            if(head == tail){
                head = tail = null;
            }else{
                head = head.getNextNode();
                head.setPreviousNode(null);
            }
            return aux.getData();
        }
    }

    public E poll() {
        if(isEmpty()){
            return null;
        }else{
            DoubleNode<E> aux = head;
            if(head == tail){
                head = tail = null;
            }else{
                head = head.getNextNode();
                head.setPreviousNode(null);
            }
            return aux.getData();
        }
    }

    public E element() throws Exception {
        if(isEmpty()){
            throw new NoSuchElementException("\033[031mError: \033[030mLa cola está vacía");
        }else{
            return head.getData();
        }
    }

    public E peek() {
        if(isEmpty()){
            return null;
        }else{
            return head.getData();
        }
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
