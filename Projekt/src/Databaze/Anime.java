package Databaze;

import java.io.Serializable;
import java.util.ArrayList;

public class Anime extends Film implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> animators;
    private int ageRating;
    private int qRating;

    public Anime(String name, String director, int releaseDate,String genre, ArrayList<String> animators, int ageRating, int qRating) {
        super(name, director, releaseDate, genre);
        this.animators = animators;
        this.ageRating = ageRating;
        this.qRating = qRating;
    }
    public void setAnimators(ArrayList<String> animators) {
        this.animators = animators;
    }

    public ArrayList<String> getAnimators() {
        return animators;
    }
    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public int getAgeRating() {
        return ageRating;
    }
    public void setqRating(int qRating) {
        if (ageRating < 1 || ageRating > 10) {
            throw new IllegalArgumentException("Hodnoceni musí být v rozmezí 1 až 10.");
        }
        this.qRating = qRating;
    }

    public int getqRating() {
        return qRating;
    }

    @Override
    public String toString() {
        return super.toString() + ", žánr: Anime, animátoři: " + animators + ", věkové omezení: " + ageRating + ", hodnocení: " + qRating;
    }
}