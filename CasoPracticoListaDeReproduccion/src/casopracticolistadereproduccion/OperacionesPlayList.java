/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticolistadereproduccion;

import java.util.Scanner;

/**
 *
 * @author Dianella
 */
public class OperacionesPlayList<T extends Comparable> {

    Song<T> head;
    Song<T> tail;

    public OperacionesPlayList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addSong(T name) {
        Song<T> newSong = new Song<>(name);
        if (isEmpty()) {
            head = tail = newSong;
            newSong.setNextSong(newSong);
        } else {
            newSong.setNextSong(head);
            tail.setNextSong(newSong);
            head = newSong;
        }
    }

    public String showPlayList() {
        String data = "";
        Song<T> current = this.head;
        do {
            data += current.getNameSong() + " \n ";
            current = current.getNextSong();
        } while (current != head);
        return data;
    }

    public boolean exist(T name) {
        if (isEmpty()) {
            return false;
        } else {
            Song<T> current = this.head;
            do {
                if (current.getNameSong().compareTo(name) == 0) {
                    return true;
                }
                current = current.getNextSong();
            } while (current != head);
            return false;
        }
    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar...");
        } else if (head == tail) {
            head = null;
        } else {
            tail.setNextSong(head.getNextSong());
            head = head.getNextSong();
        }
    }

    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("No exiten datos por borrar...");
        } else if (head == tail) {
            head = null;
        } else {
            Song<T> current = this.head;
            while (current.getNextSong() != tail) {
                current = current.getNextSong();
            }
            current.setNextSong(head);
            tail = current;
        }
    }

    public void deleteSong(T name) throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar");
        } else if (head == tail) {
            head = null;
        } else if (!exist(name)) {
            throw new Exception("El dato no existe en la play list");
        } else {
            Song<T> current = this.head;
            if (name.compareTo(head.getNameSong()) == 0) {
                delete();
            } else if (name.compareTo(tail.getNameSong()) == 0) {
                deleteLast();
            }
            do {
                if (current.getNextSong().getNameSong().compareTo(name) == 0) {
                    current.setNextSong(current.getNextSong().getNextSong());
                }
                current = current.getNextSong();
            } while (current != head && current != tail);
        }
    }

    public void update(T name, T newName) throws Exception {
        if (isEmpty()) {
            throw new Exception("No hay canciones para actualizar, la play list esta vacia...");
        } else if (!exist(name)) {
            throw new Exception("La cancion no existe...");
        } else {
            Song<T> current = this.head;
            do {
                if (current.getNameSong().compareTo(name) == 0) {
                    current.setNameSong(newName);
                }
                current = current.getNextSong();
            } while (current != head);
        }
    }

    public void autoPlay() throws Exception {
        Scanner teclado = new Scanner(System.in);
        Song<T> song = this.head;
        int opcion = 0;
        if (isEmpty()) {
            throw new Exception("La playLisy esta vacia...");
        } else {
            do {
                do {
                    try {
                        Thread.sleep(1000);
                        System.out.println("" + song.getNameSong());
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    song = song.getNextSong();
                } while (song != this.head);
                System.out.println("¿Desea volver a reproducir? 1.Si 2.No  ");
                opcion = teclado.nextInt();
            } while (opcion != 2);

        }
    }


}
