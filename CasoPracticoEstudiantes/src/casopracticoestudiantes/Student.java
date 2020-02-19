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
public class Student<T> {
    
    private String id;
    private String nameStudent;
    private String neighborhood;
    private double finalNote;
    private Student<T> previousStudent;
    private Student<T> nextStudent;
    
    public Student(String id, String nameStudent, String neighborhood, double finalNote){
        setId(id);
        setNameStudent(nameStudent);
        setNeighborhood(neighborhood);
        setFinalNote(finalNote);
    }
    
    public Student(String id, String nameStudent, String neighborhood, double finalNote, Student previousStudent, Student nextStudent){
        setId(id);
        setNameStudent(nameStudent);
        setNeighborhood(neighborhood);
        setFinalNote(finalNote);
        setPreviousStudent(previousStudent);
        setNextStudent(nextStudent);
    }
    
    public Student(Student student, Student previousStudent, Student nextStudent){
        setId(student.getId());
        setNameStudent(student.getNameStudent());
        setNeighborhood(student.getNeighborhood());
        setFinalNote(student.getFinalNote());
        setPreviousStudent(previousStudent);
        setNextStudent(nextStudent);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nameStudent
     */
    public String getNameStudent() {
        return nameStudent;
    }

    /**
     * @param nameStudent the nameStudent to set
     */
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the finalNote
     */
    public double getFinalNote() {
        return finalNote;
    }

    /**
     * @param finalNote the finalNote to set
     */
    public void setFinalNote(double finalNote) {
        this.finalNote = finalNote;
    }

    /**
     * @return the previousStudent
     */
    public Student<T> getPreviousStudent() {
        return previousStudent;
    }

    /**
     * @param previousStudent the previousStudent to set
     */
    public void setPreviousStudent(Student<T> previousStudent) {
        this.previousStudent = previousStudent;
    }

    /**
     * @return the nextStudent
     */
    public Student<T> getNextStudent() {
        return nextStudent;
    }

    /**
     * @param nextStudent the nextStudent to set
     */
    public void setNextStudent(Student<T> nextStudent) {
        this.nextStudent = nextStudent;
    }
}
