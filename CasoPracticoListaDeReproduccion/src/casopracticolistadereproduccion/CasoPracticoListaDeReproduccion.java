/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticolistadereproduccion;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dianella
 */
public class CasoPracticoListaDeReproduccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        OperacionesPlayList<String> myPlayList = new OperacionesPlayList<>();

        int opcion = 0;
        String nombreCancion = "", nombreCancion2 = "";

        do {
            System.out.println("Lista de Reproduccion de video \n");
            System.out.println("Seleccione la opción que desea realizar del 1 al 6: \n");
            System.out.println("1. Agregar cancion \n");
            System.out.println("2. Eliminar \n");
            System.out.println("3. Actualizar \n");
            System.out.println("4. Ver PlayList \n");
            System.out.println("5. Reproduccion automatica \n");
            System.out.println("6. Salir \n");
            System.out.println("¿Qué desea hacer?");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la cancion: ");
                    nombreCancion = teclado.next();
                    myPlayList.addSong(nombreCancion);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la cancion que desea eliminar: ");
                    nombreCancion = teclado.next();
                    try {
                        myPlayList.deleteSong(nombreCancion);
                    } catch (Exception ex) {
                        Logger.getLogger(CasoPracticoListaDeReproduccion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la cancion que desea cambiar: \n");
                    nombreCancion = teclado.nextLine();
                    System.out.println("Ingrese el nombre de la nueva cancion: ");
                    nombreCancion2 = teclado.nextLine();
                    try {
                        myPlayList.update(nombreCancion, nombreCancion2);
                    } catch (Exception ex) {
                        Logger.getLogger(CasoPracticoListaDeReproduccion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 4:
                    System.out.println("La playList: \n" + myPlayList.showPlayList());
                    break;
                case 5:
                    try {
                        myPlayList.autoPlay();
                    } catch (Exception ex) {
                        Logger.getLogger(CasoPracticoListaDeReproduccion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 6);

//        myPlayList.addSong("Yummy");
//        myPlayList.addSong("Baby");
//        myPlayList.addSong("No changes");
//        myPlayList.addSong("Blanco");
        //System.out.println("VER LISTA " + " \n " + myPlayList.showPlayList());
//        try {
//            myPlayList.deleteSong("Blanco");
//        } catch (Exception ex) {
//            Logger.getLogger(CasoPracticoListaDeReproduccion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            myPlayList.update("Baby", "Morado");
//        } catch (Exception ex) {
//            Logger.getLogger(CasoPracticoListaDeReproduccion.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //System.out.println("VER LISTA " + " \n " + myPlayList.showPlayList());
    }

}
