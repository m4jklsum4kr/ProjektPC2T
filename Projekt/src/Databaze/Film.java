package Databaze;

public abstract class Film {
    private String name;
    private String director;
    private int releaseDate;
    private String genre;

    public Film(String name, String director, int releaseDate, String genre) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getReleaseDate() {
        return releaseDate;
    }
    public String getGenre() {
        return this.getClass().getSimpleName();
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return name + " (" + releaseDate + "), režie: " + director + ", žánr: " + genre;
    }
}