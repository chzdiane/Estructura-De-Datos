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
public class ListasCircularesDobles<T extends Comparable> {
    
    DoubleNode<T> head;
    
    public ListasCircularesDobles(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void add(T d){
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if(isEmpty()){
            head=newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
            head.getPreviousNode().setNextNode(head);
        }
    }
    
    public void addLast(T d){
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);
        }
    }
    
    public void addOrdered(T d) throws Exception{
        if(exist(d)){
            throw new Exception("El dato ya existe en la lista");
        } else {
            if(isEmpty()){
                add(d);
            } else {
                if(d.compareTo(head.getData()) == -1){
                    add(d);
                    return;
                }
                if(d.compareTo(head.getData()) == 1){
                    addLast(d);
                    return;
                }
                DoubleNode<T> newNode = new DoubleNode<>(d);
                DoubleNode<T> current = this.head;
                
                while(d.compareTo(current.getNextNode().getData()) == -1){
                    current.getNextNode();
                }
                newNode.setNextNode(current.getNextNode());
                newNode.setPreviousNode(current);
                current.setNextNode(newNode);
            }
        }
    }
    
    public boolean exist(T d){
        if(isEmpty()){
            return false;
        } else {
            DoubleNode<T> current = head;
            do{
                if(current.getData().compareTo(d) == 0){
                    return true;
                }
                current = current.getNextNode();
            } while(current != head);
            return false;
        }
    }
    
    public String showData(){
        String data = "";
        DoubleNode<T> current = this.head;
        do {
            data += current.getData() + " ";
            current = current.getNextNode();
        } while(current != head);
        return data;
    }
    
    public ListasCircularesDobles<T> divideList(T d) throws Exception{
        
        if(isEmpty()){
            throw new Exception("La lista esta vacia");
        } else if(!exist(d)){
            throw new Exception("El dato no existe");
        } else {
            DoubleNode<T> current = this.head;
            ListasCircularesDobles<T> newList = new ListasCircularesDobles<>();
            do{
                if(current.getData().compareTo(d) == 0 && current == this.head){
                    return this;
                } else if(current.getData().compareTo(d) == 0){
                    do{
                        if(current.getData().equals(d)){
                            newList.add(current.getData());
                            current = current.getNextNode();
                        } else {
                            newList.addLast(current.getData());
                            current = current.getNextNode();
                        }
                    } while (current != this.head);
                    //deleteNode(d);
                    return newList;
                }
                current = current.getNextNode();
            } while(current != this.head);
            return newList;
        }  
    }
    
}
