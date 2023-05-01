package Databaze;
//slozka databaze je kvuli lepsi orientaci v programu. Napad jsem pak scrapnul.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FilmDatabase db = new FilmDatabase();

        while(true)
        {
            System.out.println("Vyber si:");
            System.out.println("1...Pridat Film");
            System.out.println("2...Upravit Film");
            System.out.println("3...Smazat Film");
            System.out.println("4...Vypis Filmu");
            System.out.println("5...Vyhledani Filmu");
            System.out.println("6...Vypis Talentovanych pracovniku");
            System.out.println("7...Vypis Filmu podle pracovnika");
            System.out.println("8...Save");
            System.out.println("9...Load.... Nacteni nefunguje nestihl implementovat");
            System.out.println("0...Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("SO LONG SUCKER!!!!!");
                    System.exit(0);
                    break;
                case 1:
                    FilmDatabase.addFilm();
                    break;
                case 2:
                    System.out.print("Zadejte nazev filmu: ");
                    String name = scanner.nextLine();
                    Film filmToEdit = FilmDatabase.findFilmByName(name);
                    if (filmToEdit == null) {
                        System.out.println("Film nenalezen");
                    } else {
                        FilmDatabase.editFilm(filmToEdit);
                    }
                    break;
                case 3:
                    System.out.print("Zadejte nazev filmu: ");
                    String filmName = scanner.nextLine();
                    FilmDatabase.deleteFilm(filmName);
                    break;
                case 4:
                    FilmDatabase.printFilms();
                    break;

                case 5:
                    System.out.print("Zadejte nazev filmu: ");
                    String searchName = scanner.nextLine();
                    FilmDatabase.searchFilm(searchName);
                    break;
                case 6:
                    FilmDatabase.printTalentedWorkers();
                    break;
                case 7:
                    System.out.print("Zadejte jmeno herce: ");
                    String actorName = scanner.nextLine();
                    FilmDatabase.findMoviesByWorker(actorName);
                    break;
                case 8:
                    FilmDatabase.saveToFile();
                    break;
                case 9:
                    System.out.println("Nacteni nefunguje nestihl implementovat");
                    break;
                default:
                    System.out.println("Neplatna volba");
                    break;
            }
        }
    }
}