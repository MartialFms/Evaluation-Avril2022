package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import fr.fms.entities.Book;

public class BookDao implements Dao<Book> {

	Connection connection = BddConnection.getConnection();

	@Override
	public boolean create(Book book) {
		try {
			String query = "INSERT INTO T_Books (Title, Author, ThemeId, UnitaryPrice) VALUES (?, ?, ?, ?)";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, book.getTitle());
			prepStat.setString(2, book.getAuthor());
			prepStat.setInt(3, book.getThematic());
			prepStat.setDouble(4, book.getUnitaryPrice());
			if (prepStat.executeUpdate() == 1)
				System.out.println("Succefull insert !");
			return true;
		} catch (SQLException e) {
			System.out.println("Insert Error !");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Book read(int id) {
		String query = "SELECT * FROM T_Books WHERE BookId = ? ;";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setInt(1, id);
			ResultSet result = prepStat.executeQuery();
			if (result.next())
				System.out.println(new Book(result.getInt(1), result.getString(2), result.getString(3),
						result.getInt(4), result.getDouble(5)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Book book) {
		String query = "UPDATE T_Books SET Title = ?, Author = ?, ThemeId = ?, UnitaryPrice = ? WHERE BookId= ? ";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, book.getTitle());
			prepStat.setString(2, book.getAuthor());
			prepStat.setInt(3, book.getThematic());
			prepStat.setDouble(4, book.getUnitaryPrice());
			prepStat.setInt(5, book.getBookId());
			if (prepStat.executeUpdate() == 1)
				System.out.println("Succefull updated !");
			return true;
		} catch (SQLException e) {
			System.out.println("Update Error !");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Book book) {
		String query = "DELETE FROM T_Articles where IdArticle= ? ";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setInt(1, book.getBookId());
			if (prepStat.executeUpdate() == 1)
				System.out.println("Succefull deleted !");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete Error !");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Book> readAll() {
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM T_Articles";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				int resultBookId = result.getInt(1);
				String resultTitle = result.getString(2);
				String resultAuthor = result.getString(3);
				int resultThematic = result.getInt(4);
				double resultPrice = result.getDouble(5);
				books.add((new Book(resultBookId, resultTitle, resultAuthor, resultThematic, resultPrice)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public ArrayList<Book> readAllByTheme(int themeId) {
		ArrayList<Book> books = new ArrayList<Book>();
		String query = "SELECT * FROM T_Articles where ThemeId = ?";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setInt(1, themeId);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				int resultBookId = result.getInt(1);
				String resultTitle = result.getString(2);
				String resultAuthor = result.getString(3);
				int resultThematic = result.getInt(4);
				double resultPrice = result.getDouble(5);
				books.add((new Book(resultBookId, resultTitle, resultAuthor, resultThematic, resultPrice)));
			}
			} catch (SQLException e) {
			e.printStackTrace(); 
		}
		// ArrayList<Book> sortedBooks = (ArrayList<Book>) books.stream().map(e -> {return new Book(e.getBookId(), e.getTitle(), e.getAuthor(), e.getThematic(), e.getUnitaryPrice()); }).collect(Collectors.toList());
		//return sortedBooks;
		return books;
	}


}



//
//
//
//int bookId = resultat.getInt("BookId");
//String title = resultat.getString("Title");
//String author = resultat.getString("Author");
//String thematic = resultat.getString("ThemeId");
//double unitaryPrice = resultat.getDouble("UnitaryPrice");	