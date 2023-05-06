package com.skilldistillery.film.appdelete;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.data.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmQueryApp {

	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(4); //change to 0
//		if (film != null) {
//			System.out.println(film);
//		} else {
//			System.out.println("No film found for search.");
//		}
//
//		Actor actor = db.findActorById(0);
//		if (actor != null) {
//			System.out.println(actor);
//		} else {
//			System.out.println("No actor found for search.");
//		}
//
//		List<Film> actorIdToFilm = db.findFilmsByActorId(0);
//		if (!actorIdToFilm.isEmpty()) {
//			System.out.println(actorIdToFilm);
//		} else {
//			System.out.println("No film found for search.");
//		}
//
//		List<Actor> filmIdToActor = db.findActorsByFilmId(0);
//		if (!filmIdToActor.isEmpty()) {
//			System.out.println(filmIdToActor);
//		} else {
//			System.out.println("No actor found for search.");
//		}
//		
//		String title = "TEST2";
//		String desc = "blah blah";
//		int year = 1999;
//		int duration = 10;
//		double rate = 5.55;
//		int length = 3;
//		double cost = 22.22;
//		String rating = "PG13";
////		the 1 is language_id being hardcoded
//		Film tester = new Film(title, desc, year, 1, duration, rate, length, cost, rating);
//		Film createdFilm = db.createFilm(tester);
//		if (createdFilm != null) {
//			System.out.println(createdFilm);
//		} else {
//			System.out.println("Film not created.");
//		}
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		int selection;
		menu();
		do {
			selection = input.nextInt();
			input.nextLine();
			switch (selection) {
			case 1:
				printFilmFromId(input);
				break;
			case 2:
				printFilmFromKeyword(input);
				break;
			case 3:
				addNewFilm(input);
				break;
			case 4:
				updateFilm(input);
				break;
			case 5:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid selection.\n");
				menu();
				break;
			}
		} while (selection != 5);
	}

	private void menu() {
		System.out.println("1) Look up film by film id");
		System.out.println("2) Look up film by keyword");
		System.out.println("3) Add new film");
		System.out.println("4) Update film");		
		System.out.println("5) Exit");
	}

	private void printFilmFromId(Scanner input) {
		System.out.print("\nEnter film id: ");
		int idSelection = input.nextInt();
		input.nextLine();
		Film film = db.findFilmById(idSelection);
		if (film != null) {
			System.out.print(film.getTitle() + ", Released: " + film.getReleaseYear() + ", Rating: " + film.getRating()
					+ ", Language: " + db.getFilmLang(film) + "\nActors: ");
			List<Actor> actors = film.getActors();
			for (Actor actor : actors) {
				if (actors.indexOf(actor) < actors.size() - 1) {
					System.out.print(actor + ", ");
				} else {
					System.out.print(actor);
				}
			}
			System.out.println("\n" + film.getDesc());
			System.out.println();
		} else {
			System.out.println("No film found for search.\n");
		}
		menu();
	}

	private void printFilmFromKeyword(Scanner input) {
		System.out.print("\nEnter film keyword: ");
		String keyword = input.next();
		input.nextLine();
		List<Film> filmWordSearch = db.findFilmByKeyword(keyword);
		if (!filmWordSearch.isEmpty()) {
			for (Film movie : filmWordSearch) {
				int id = movie.getFilmId();
				System.out.print(movie.getTitle() + ", Released: " + movie.getReleaseYear() + ", Rating: "
						+ movie.getRating() + ", Language: " + db.getFilmLang(movie) + "\nActors: ");
				List<Actor> actors = db.findActorsByFilmId(id);
				for (Actor actor : actors) {
					if (actors.indexOf(actor) < actors.size() - 1) {
						System.out.print(actor + ", ");
					} else {
						System.out.print(actor);
					}
				}
				System.out.println("\n" + movie.getDesc());
				System.out.println();
			}
		} else {
			System.out.println("No film found for search.\n");
		}
		menu();
	}

	private void addNewFilm(Scanner input) {
		System.out.print("\nEnter the films title: ");
		String title = input.next();
		input.nextLine();
		System.out.print("\nEnter the films rental duration: ");
		int duration = input.nextInt();
		input.nextLine();
		System.out.print("\nEnter the films rental rate: ");
		double rate = input.nextDouble();
		input.nextLine();
		System.out.print("\nEnter the films replacement cost: ");
		double cost = input.nextDouble();
		input.nextLine();

		Film newFilm = new Film(title, 1, duration, rate, cost);
		Film createdFilm = db.createFilm(newFilm);
		if (createdFilm != null) {
			System.out.println("\n" + createdFilm);
			int selection;
			do {
				System.out.println("\nWould you like to keep (1) or delete (2)?");
				selection = input.nextInt();
				input.nextLine();
				switch (selection) {
				case 1:
					System.out.println("Added to database!\n");
					break;
				case 2:
					System.out.println("Deleted film.\n");
					deleteFilm(createdFilm);
					break;
				default:
					System.out.println("Invalid selection.\n");
					break;
				}
			} while (selection > 2);

		} else {
			System.out.println("Film not created.\n");
		}
		menu();
	}

	private void deleteFilm(Film film) {
		db.deleteFilm(film);
	}
	
	private void updateFilm(Scanner input) {		
		System.out.print("\nEnter the films id: ");
		int id = input.nextInt();
		input.nextLine();
		System.out.print("\nEnter the films updated title: ");
		String title = input.next();
		input.nextLine();
		System.out.print("\nEnter the films updated rental duration: ");
		int duration = input.nextInt();
		input.nextLine();
		System.out.print("\nEnter the films updated rental rate: ");
		double rate = input.nextDouble();
		input.nextLine();
		System.out.print("\nEnter the films updated replacement cost: ");
		double cost = input.nextDouble();
		input.nextLine();

		
		Film updateFilm = new Film(title, 1, duration, rate, cost);
		Film updatedFilm = db.updateFilm(id, updateFilm);
		if (updatedFilm != null) {
			System.out.println("\n" + updatedFilm);
			int selection;
			do {
				System.out.println("\nWould you like to keep (1) or delete (2)?");
				selection = input.nextInt();
				input.nextLine();
				switch (selection) {
				case 1:
					System.out.println("Updated film in database!\n");
					break;
				case 2:
					System.out.println("Deleted updates.\n");
					deleteFilm(updatedFilm);
					break;
				default:
					System.out.println("Invalid selection.\n");
					break;
				}
			} while (selection > 2);

		} else {
			System.out.println("Film not updated.\n");
		}
		menu();
	}

}
