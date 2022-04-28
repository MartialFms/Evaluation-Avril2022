
package fr.fms.business;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.BookDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.User;

public class BuisnessImpl implements Buisness {
	private HashMap<Integer, Book> cart;
	private ArrayList<Book> books = new ArrayList<Book>();

	private Dao<Book> bookDao = DaoFactory.getBookDao();
	private Dao<Customer> userDao = DaoFactory.getUserDao();
	private OrderDetail orderBook;

	public BuisnessImpl() {
		this.cart = new HashMap<Integer, Book>();
	}

	public ArrayList<Book> showBooks(Book book) {
		return bookDao.readAll();
	}

	public ArrayList<Book> showBooksByTheme(Book book) {
		BookDao bookdao;
		return bookdao.readAllByTheme(book.getThematic());
	}

// class OrdreDetails ??
	public boolean addToCart(Book book, int quantity) {
		Book orderBook = cart.get(book.getBookId()); // ------------------------------
		if (orderBook != null) {
			orderBook.setQuantity(orderBook.getQuantity() + quantity);
		} else
			cart.put(book.getBookId(), book);
		return bookDao.update(orderBook);
	}

	// class OrdreDetails ??    >> OrderDetail test;
	public boolean removeFromCart(Book book, int orderQuantity) {
		orderBook.setOrderId(book.getBookId());
		
		
		 
		Book orderBook = cart.get(OrderDetail.getBookId()); // -------------------
		int bookQuantity = orderBook.getQuantity();
		if (orderBook != null && orderQuantity <= bookQuantity)
			orderBook.setQuantity(bookQuantity - orderQuantity);
		return bookDao.update(book);
	}


	public ArrayList<Book> getCart() {
	}

	public int order(int idUser) {
	}

}