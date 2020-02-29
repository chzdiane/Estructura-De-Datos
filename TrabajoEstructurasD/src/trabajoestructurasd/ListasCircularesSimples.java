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
public class ListasCircularesSimples<T extends Comparable> {
    
    Node<T> head;
    Node<T> tail;
    
    public ListasCircularesSimples(){
        head = tail = null; 
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    private Node<T> addNode(T d){
        Node<T> newNode = new Node<>(d);
        if(isEmpty()){
            head = tail = newNode;
            newNode.setNextNode(newNode);
        } else {
            newNode.setNextNode(head);
            tail.setNextNode(newNode);
        }
        return newNode;
    }
    
    public void add(T d) {
        head = addNode(d);
    }
    
    public void addLast(T d){
        tail = addNode(d);
    }
    
    public void addOrdered(T d) throws Exception{
        
        if(exist(d)){
            throw new Exception("El dato ya existe en la lista");
        } else {
            if(isEmpty()){
                add(d);
            } else {
                if(d.compareTo(head.getData()) == 1){
                    add(d);
                    return;
                }
                if(d.compareTo(head.getData()) == -1){
                    addLast(d);
                    return;
                }
                Node<T> newNode = new Node<>(d);
                Node<T> current = this.head;
                
                while(d.compareTo(current.getNextNode().getData()) == -1){
                    current = current.getNextNode();
                }
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
            }
        }
    }
    
    public String toGoSpecifycData(T d){
        
        String data= "";
        Node<T> current = this.head;
        do{
            if(current.getData().compareTo(d) == 0){
                do{
                    data += current.getData() + " ";
                    current = current.getNextNode();
                } while(current.getData() != d);
                return data;
            }
            current = current.getNextNode();
        } while (current != head);
        return data;
    }
    
    public boolean exist(T d){
        if(isEmpty()){
            return false;
        } else{
            Node<T> current = head;
            do{
                if(current.getData().compareTo(d) == 0){
                return true;
            }
            current = current.getNextNode();
        } while (current != head);
        return false;
        }
    }
    
    public String showData(){
        String data= "";
        Node<T> current = this.head;
        do{
            data += current.getData() + " ";
            current = current.getNextNode();
        } while (current != head);
        return data;
    }
    
    public ListasCircularesSimples<T> joinList(ListasCircularesSimples list) throws Exception{
        if(list.isEmpty()){
            throw new Exception("La lista no tiene datos para unir");
        } else {
            Node<T> current = list.head;
            do{
                addLast(current.getData());
                current =current.getNextNode();
            } while(current != list.head);
        }
        return this;
    }
    
}
