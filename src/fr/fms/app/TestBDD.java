package fr.fms.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.dao.BddConnection;
import fr.fms.entities.Book;

public class TestBDD {

	private static ArrayList<Book> books = new ArrayList<Book>();
	
	public static void main(String[] args) {
		extractData();
		books.forEach(e -> System.out.println(e));
	}
	
	public static ArrayList<Book> extractData() {
		
		try {
			Connection connection =  BddConnection.getConnection();
			Statement statement = connection.createStatement();

			// Ex�cution de la requ�te
			ResultSet resultat = statement.executeQuery("SELECT * FROM T_Books;");

			// R�cup�ration des donn�es
			while (resultat.next()) {
				int bookId = resultat.getInt("BookId");
				String title = resultat.getString("Title");
				String author = resultat.getString("Author");
				int thematic = resultat.getInt("ThemeId");
				double unitaryPrice = resultat.getDouble("UnitaryPrice");	

				Book book = new Book();
				book.setBookId(bookId);
				book.setTitle(title);
				book.setAuthor(author);
				book.setThematic(thematic);
				book.setUnitaryPrice(unitaryPrice);
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur de recuperation des donn�es");
			e.printStackTrace();
		}
		return books;
	}

}
