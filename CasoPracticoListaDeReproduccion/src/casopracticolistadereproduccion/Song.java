/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticolistadereproduccion;

/**
 *
 * @author Dianella
 */
public class Song<T> {
    
    private T nameSong;
    private Song<T> nextSong;
    
    public Song(T name){
        this.nameSong = name;
        nextSong = null; 
    }
    
    public Song(T name, Song<T> nextSong){
        this.nameSong = name;
        this.nextSong = nextSong;
    }

    /**
     * @return the nameSong
     */
    public T getNameSong() {
        return nameSong;
    }

    /**
     * @param nameSong the nameSong to set
     */
    public void setNameSong(T nameSong) {
        this.nameSong = nameSong;
    }

    /**
     * @return the nextSong
     */
    public Song<T> getNextSong() {
        return nextSong;
    }

    /**
     * @param nextSong the nextSong to set
     */
    public void setNextSong(Song<T> nextSong) {
        this.nextSong = nextSong;
    }
    
}
