/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

/**
 *
 * @author Dianella
 */
public class LinkedStack<E> {
    
    private Node<E> top;
    private int sizeStack;

    public LinkedStack() {
        top = null;
        sizeStack = 0;
    }

    public boolean empty() {
        return top == null;
    }

    public E peek() {

        return (empty())?null:top.getData();
        
//        if(empty()){
//            return null;
//        }else{
//            return top.getData();
//        }
            
        
    }

    public E pop() {
        if (empty()) {
            return null;
        } else {
            E dataTemp = top.getData();
            top = (top.getNextNode() == null) ? null : top.getNextNode();
//            if (top.getNextNode()==null){
//                top=null;
//            }else{
//                top = top.getNextNode();
//            }

            sizeStack--;
            return dataTemp;
        }
    }

    public E push(E item) {
        sizeStack++;
        top = new Node<E> (item, top);
        return item;
    }


    public int search(E o) {
        Node<E> current = this.top;
        int posicion = 1;
        while(current != null){
            if(this.top.getData().equals(o)){
                return posicion;
            }else if(current.getData().equals(o)){
                return posicion;
            }else{
                current = current.getNextNode();
                posicion++;
            }
        }
        return -1;
    }
    
    public Node<E> getTop(){
        return this.top;
    }
}
