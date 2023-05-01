package Databaze;

import java.io.Serializable;
import java.util.ArrayList;



public class Hrane extends Film implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> actors;
    private int rating;



    public Hrane(String name, String director, int releaseDate,String genre, ArrayList<String> actors, int rating) {
        super(name, director, releaseDate, genre);
        this.actors = actors;
        this.rating = rating;
    }

    public ArrayList<String> getActors() {
        return actors;
    }
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        if ( rating < 1 || rating > 5) {
        throw new IllegalArgumentException("Hvezdicek musí být MAX 5");
    }
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString() + ", žánr: Hrané, herci: " + actors + ", hodnocení: " + rating;
    }

}