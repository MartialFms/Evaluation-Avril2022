package fr.fms.app;

import java.util.Scanner;

import fr.fms.dao.BookDao;
import fr.fms.entities.Book;

public class TestBookDao {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("CRUD Test --> 1-Create , 2-Read, 3-Update, 4-Delete, 5-ReadAll");
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			createBook();
			break;
		case 2:
			readBook();
			break;
		case 3:
			updateBook();
			break;
		case 4:
			deleteBook();
			break;
		case 5:
			readAllBook();
			break;
		case 6:
			readAllBookByTheme();
			break;

		}
	}

	public static void createBook() {
		// Questions
		System.out.println("Test CREATE");
		Book book = new Book();
		System.out.println("Titre : ");
		String bookTitle = scan.next();
		System.out.println("Auteur : ");
		String bookAuthor = scan.next();
		System.out.println("Theme : ");
		int bookTheme = scan.nextInt();
		System.out.println("Prix : ");
		double bookPrice = scan.nextDouble();
		// Set object
		book.setTitle(bookTitle);
		book.setAuthor(bookAuthor);
		book.setThematic(bookTheme);
		book.setUnitaryPrice(bookPrice);
		// Dao action
		System.out.println(" Objet ---->> " + book);
		BookDao creationDao = new BookDao();
		creationDao.create(book);
	}

	public static void readBook() {
		// Questions
		System.out.println("Test READ");
		System.out.println("Id : ");
		int targetId = scan.nextInt();

		BookDao consultDao = new BookDao();
		Book targetBook = consultDao.read(targetId);
		System.out.println(targetBook);
	}

	public static void updateBook() {
		// Questions
		System.out.println("Test UPDATE");
		System.out.println("Id : ");
		int targetId = scan.nextInt();

		BookDao deleteDao = new BookDao();
		Book targetBook = deleteDao.read(targetId);

		System.out.println("Id : ");
		double newPrice = scan.nextInt();

		targetBook.setUnitaryPrice(newPrice);
		deleteDao.update(targetBook);
	}

	public static void deleteBook() {
		// Questions
		System.out.println("Test DELETE");
		System.out.println("Id : ");
		int targetId = scan.nextInt();

		BookDao deleteDao = new BookDao();
		Book targetBook = deleteDao.read(targetId);
		deleteDao.delete(targetBook);
	}

	public static void readAllBook() {
		// Questions
		System.out.println("Test READ ALL");
		BookDao allConsultDao = new BookDao();
		allConsultDao.readAll();
	}

	public static void readAllBookByTheme() {
		// Questions
		System.out.println("Test READ ALL");
		BookDao themeConsultDao = new BookDao();
		themeConsultDao.readAll();
	}

}
