/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticoestudiantes;

/**
 *
 * @author Dianella
 */
public class ListasDoblesEstudiante<T> {
    
    private Student<T> head;
    private Student<T> tail;
    
    public ListasDoblesEstudiante(){
        head = tail = null;
    }
    
    public boolean isEmpty(){
        return head==null;
    }
    
    public void add(Student<T> student){
        if(isEmpty()){
            head = tail = new Student(student,null,null);
        } else {
            head = new Student(student, null, head);
            head.getNextStudent().setPreviousStudent(student);
        }
    }
    
    public void addStudent(String id, String nameStudent, String neighborhood, double finalNote){
        if(isEmpty()){
            head = tail = new Student(id, nameStudent, neighborhood, finalNote);
        } else {
            if(finalNote >= 3.0){
                head = new Student(id, nameStudent, neighborhood,finalNote, null, head);
                head.getNextStudent().setPreviousStudent(head);
            } else {
                if(finalNote <3.0){
                tail = new Student(id, nameStudent, neighborhood,finalNote, tail, null);
                tail.getPreviousStudent().setNextStudent(tail);
                }
            }
            
        }
    }
    
    public String showStudent(){
        String data = "";
        Student<T> current = this.head;
        while(current != null){
            data += "Cedula: " + current.getId() + " Nombre: " + current.getNameStudent() + " Barrio: " + current.getNeighborhood() + " Nota final: " + current.getFinalNote() + "\n";
            current = current.getNextStudent();
        }
        return data;
    }
    
    public boolean existId(String id){
        Student<T> current = head;
        while(current != null){
            if(current.getId().compareTo(id) == 0){
                return true;
            }
            current = current.getNextStudent();
        }
        return false;
    }
    
    public boolean existNeighborhood(String neighborhood){
        Student<T> current = head;
        while(current != null){
            if(current.getNeighborhood().compareTo(neighborhood) == 0){
                return true;
            }
            current = current.getNextStudent();
        }
        return false;
    }
    
    public String searchId(String id) throws Exception{
        String data = "";
        if(isEmpty()){
            throw new Exception("La lista esta vacia");
        } else if(!existId(id)) {
            throw new Exception("El estudiante no se encuentra en la lista");
        } else {
            Student<T> current = this.head;
            while(current != null){
                if(current.getId().compareTo(id) == 0){
                    data += "Cedula " + current.getId() + " Nombre " + current.getNameStudent() + " Barrio " + current.getNeighborhood() + " Nota final " + current.getFinalNote();
                }
                current = current.getNextStudent();
            }
            return data;
        }
    }
    
    public String searchNeighborhood(String neighborhood) throws Exception{
        String data ="";
        if(isEmpty()){
            throw new Exception("La lista esta vacia");
        } else if(!existNeighborhood(neighborhood)){
            throw new Exception("El estudiante no se encuentra en la lista");
        } else {
            Student<T> current = this.head;
            while(current != null){
                if(current.getNeighborhood().compareTo(neighborhood) == 0){
                    data += "Nombre " + current.getNameStudent() + " " + "\n";
                }
                current = current.getNextStudent();
            }
            return data;
        }
    }
    
    public ListasDoblesEstudiante<T> newListApproved() throws Exception {
        if(isEmpty()){
            throw new Exception("La lista esta vacia");
        } else {
            Student<T> current = this.head;
            ListasDoblesEstudiante<T> approved = new ListasDoblesEstudiante<>();
            while(current != null){
                if(current.getFinalNote() >= 3.0){
                    approved.add(current);
                }
                current = current.getNextStudent();
            }
            return approved;
        }
    }
    
    public ListasDoblesEstudiante<T> newListFailed() throws Exception {
        if(isEmpty()){
            throw new Exception("La lista esta vacia");
        } else {
            Student<T> current = this.head;
            ListasDoblesEstudiante<T> failed = new ListasDoblesEstudiante<>();
            while(current != null){
                if(current.getFinalNote() < 3.0){
                    failed.add(current);
                }
                current = current.getNextStudent();
            }
            return failed;
        }
    }
    
}
