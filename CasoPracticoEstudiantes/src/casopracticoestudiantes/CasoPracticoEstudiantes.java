/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticoestudiantes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dianella
 */
public class CasoPracticoEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListasDoblesEstudiante<Student> miLista = new ListasDoblesEstudiante<>();
        
        miLista.addStudent("1000290655", "Dianella", "Calasanz", 3.8);
        miLista.addStudent("1000567890", "Juan", "Robledo", 3.5);
        miLista.addStudent("43250286", "Juliana", "Calasanz", 2.0);
        miLista.addStudent("32453622", "Nelly", "Colores", 2.8);
        miLista.addStudent("1037621741", "Diego", "Sabaneta", 5.0);
        
        System.out.println(miLista.showStudent());
        
        try {
            System.out.println("La persona con el id encontrada es: " + miLista.searchId("1000290655"));
        } catch (Exception ex) {
            Logger.getLogger(CasoPracticoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            System.out.println("La persona/s con el barrio encontrado es: " + miLista.searchNeighborhood("Calasanz"));
        } catch (Exception ex) {
            Logger.getLogger(CasoPracticoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ListasDoblesEstudiante<Student> aprovados = miLista.newListApproved();
            System.out.println("La lista de personas que aprovaron el curso son: " + aprovados.showStudent());
        } catch (Exception ex) {
            Logger.getLogger(CasoPracticoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ListasDoblesEstudiante<Student> reprobados = miLista.newListFailed();
            System.out.println("La lista de personas que reprobaron el curso son: " + reprobados.showStudent());
        } catch (Exception ex) {
            Logger.getLogger(CasoPracticoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
