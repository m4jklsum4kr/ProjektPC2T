package Databaze;
import java.util.*;
import java.lang.System;
import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;


public class FilmDatabase {

    public static List<Film> films;

    public FilmDatabase() {
        films = new ArrayList<>();
    }

    public static void addFilm() {
        Scanner scanner = new Scanner(System.in);
        out.println("Zadejte název filmu: ");
        String name = scanner.nextLine();
        out.println("Zadejte jméno režiséra: ");
        String director = scanner.nextLine();
        out.println("Zadejte rok vydání: ");
        int releaseDate = scanner.nextInt();
        out.println("Zadejte žánr: ");
        String genre = scanner.next();

        if (genre.equalsIgnoreCase("Anime")) {
            out.println("Zadejte věkové omezení: ");
            int ageRating = scanner.nextInt();
            scanner.nextLine();
            out.println("Zadejte hodnocení: ");
            int qRating = 0;
            while (qRating < 1 || qRating > 10) {
                out.println("Hodnocení musí být v rozmezí 1 až 10.");
                qRating = scanner.nextInt();
                scanner.nextLine();
            }
            scanner.nextLine();
            out.println("Zadejte animátory: ");
            ArrayList<String> animators = new ArrayList<String>();
            while (true) {
                String animatorInput = scanner.nextLine().trim();
                if (animatorInput.equalsIgnoreCase("konec")) {
                    break;
                }
                animators.add(animatorInput);
                out.println("Zadejte dalšího animátora nebo zadejte 'konec': ");
            }
            films.add(new Anime(name, director, releaseDate, genre, animators, ageRating, qRating));
        } else if (genre.equalsIgnoreCase("Hrane")) {
            out.println("Zadejte herce: ");
            ArrayList<String> actors = new ArrayList<String>();
            while (true) {
                String actorInput = scanner.nextLine().trim();
                if (actorInput.equalsIgnoreCase("konec")) {
                    break;
                }
                actors.add(actorInput);
                out.println("Zadejte dalšího herce nebo zadejte 'konec': ");
            }
            out.println("Zadejte hodnocení: ");
            int rating = 0;
            while (rating < 1 || rating > 5) {
                out.println("Hodnocení musí být v rozmezí 1 až 5.");
                rating = scanner.nextInt();
                scanner.nextLine();
            }
            films.add(new Hrane(name, director, releaseDate, genre, actors, rating));
        } else {
            out.print("Neplatný žánr");
        }
    }

    public static Film findFilmByName(String name) {
        for (Film film : films) {
            if (film.getName().equals(name)) {
                return film;
            }
        }
        return null;
    }

    public static void editFilm(Film film) {
        Scanner input = new Scanner(System.in);

        System.out.println("OG detaily filmu: ");
        System.out.println(film);

        System.out.println("Zadejte nove detaily filmu: ");

        System.out.print("Zadejte nazev filmu: ");
        String name = input.nextLine();
        film.setName(name);

        System.out.print("Zadejte jmeno rezisera: ");
        String director = input.nextLine();
        film.setDirector(director);

        System.out.print("Zadejte rok vydani: ");
        int releaseDate = input.nextInt();
        input.nextLine();
        film.setReleaseDate(releaseDate);

        if (film instanceof Hrane) {
            Hrane hrane = (Hrane) film;

            System.out.print("Zadejte herce: ");
            out.println("Zadejte herce: (konec pro END)");
            ArrayList<String> Actors = new ArrayList<>();
            while (true) {
                String actorInput = input.nextLine();
                if (actorInput.equalsIgnoreCase("konec")) {
                    break;
                }
                Actors.add(actorInput);
            }
            hrane.setActors(Actors);

            System.out.print("Zadejte hodnoceni: ");
            while (true) {
                int rating = input.nextInt();
                if (rating < 1 || rating > 5) {
                    out.println("Hodnocení musí být v rozmezí 1 až 5.");
                } else {
                    hrane.setRating(rating);
                    break;
                }
            }
        } else if (film instanceof Anime) {
            Anime anime = (Anime) film;

            out.println("Zadejte animátory: (konec pro END)");
            ArrayList<String> animators = new ArrayList<String>();
            while (true) {
                String animatorInput = input.nextLine();
                if (animatorInput.equalsIgnoreCase("konec")) {
                    break;
                }
                animators.add(animatorInput);
            }
            anime.setAnimators(animators);

            System.out.print("Zadejte vekove omezeni: ");
            int AgeRating = input.nextInt();
            input.nextLine();
            anime.setAgeRating(AgeRating);

            System.out.print("Zadejte hodnoceni: ");
            while (true) {
                int qRating = input.nextInt();
                if (qRating < 1 || qRating > 10) {
                    out.println("Hodnocení musí být v rozmezí 1 až 10.");
                } else {
                    anime.setqRating(qRating);
                    break;
                }
            }
        } else {
            System.out.println("Film není typu Hrane ani Anime a nelze ho upravit.");
            return;
        }

        System.out.println("Detaily filmu po uprave: ");
        System.out.println(film);
    }

    public static void deleteFilm(String name) {
        Film filmToDelete = findFilmByName(name);
        if (filmToDelete == null) {
            out.println("Film\"" + name + "\"nenalezen");
            return;
        }
        films.remove(filmToDelete);
        out.println("Film\"" + name + "\"smazán");
    }

    public static void printFilms() {
        if (films.isEmpty()) {
            out.println("Databáze je prázdná");
            return;
        }

        for (Film film : films) {
            out.print("Název: " + film.getName() + ", ");
            out.print("Režisér: " + film.getDirector() + ", ");
            out.print("Rok vydání: " + film.getReleaseDate() + ", ");
            out.print("Žánr: " + film.getGenre() + ", ");
            if (film instanceof Hrane) {
                Hrane hrane = (Hrane) film;
                out.print("Herci: " + hrane.getActors() + ", ");
                out.print("Hodnocení: " + hrane.getRating() + "Hvezdicek. ");
            } else if (film instanceof Anime) {
                Anime anime = (Anime) film;
                out.print("Animátoři: " + anime.getAnimators() + ", ");
                out.print("Věkové omezení: " + anime.getAgeRating() + ", ");
                out.print("Hodnocení: " + anime.getqRating());
            }
            out.println();
        }
    }

    public static void searchFilm(String searchName) {
        boolean found = false;
        for (Film film : films) {
            if (film.getName().contains(searchName)) {
                out.println("Film nalezen:" + film.getName());
                out.println("Reziser: " + film.getDirector());
                out.println("Rok vydani: " + film.getReleaseDate());
                if (film instanceof Anime) {
                    out.println("Vekove omezeni: " + ((Anime) film).getAgeRating());
                    out.println("Hodnoceni: " + ((Anime) film).getqRating());
                } else if (film instanceof Hrane) {
                    out.println("Herci: " + ((Hrane) film).getActors());
                    out.println("Hodnoceni: " + ((Hrane) film).getRating());
                }
                found = true;
            }
        }
        if (!found) {
            out.println("Film nenalezen");
        }
    }

    public static void printTalentedWorkers() {
        Map<String, List<String>> workersMap = new HashMap<>();
        for (Film film : films) {
            if (film instanceof Anime) {
                for (String Animators : ((Anime) film).getAnimators()) {
                    if (workersMap.containsKey(Animators)) {
                        workersMap.get(Animators).add(film.getName());
                    } else {
                        List<String> filmsList = new ArrayList<>();
                        filmsList.add(film.getName());
                        workersMap.put(Animators, filmsList);
                    }
                }
            } else if (film instanceof Hrane) {
                for (String actor : ((Hrane) film).getActors()) {
                    if (workersMap.containsKey(actor)) {
                        workersMap.get(actor).add(film.getName());
                    } else {
                        List<String> filmsList = new ArrayList<>();
                        filmsList.add(film.getName());
                        workersMap.put(actor, filmsList);
                    }
                }
            }
            for (Map.Entry<String, List<String>> entry : workersMap.entrySet()) {
                String worker = entry.getKey();
                List<String> filmsList = entry.getValue();
                if (filmsList.size() > 1) {
                    out.println(worker + ": " + filmsList);
                }
            }
        }
    }

    public static void findMoviesByWorker(String workerName) {
        boolean found = false;
        for (Film film : films) {
            if (film instanceof Anime) {
                for (String animator : ((Anime) film).getAnimators()) {
                    if (animator.equals(workerName)) {
                        out.println("Film: " + film.getName());
                        found = true;
                    }
                }
            } else if (film instanceof Hrane) {
                for (String actor : ((Hrane) film).getActors()) {
                    if (actor.equals(workerName)) {
                        out.println("Film: " + film.getName());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            out.println("Žádný film nenalezen");
        }
    }

    public static void saveToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("films.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(films);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Uloženo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}