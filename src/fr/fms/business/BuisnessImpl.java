
package fr.fms.business;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.BookDao;
import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.OrderDetailsDao;
import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;

import fr.fms.entities.User;

public class BuisnessImpl implements Buisness {
	private HashMap<Integer, OrderDetail> cart;
	private ArrayList<Book> books = new ArrayList<Book>();

	private Dao<Book> bookDao = DaoFactory.getBookDao();
	private Dao<Customer> userDao = DaoFactory.getUserDao();
	private Dao<Order> orderDao = DaoFactory.getOrderDao();
	private Dao<OrderDetail> orderDetailsDao = DaoFactory.getOrderDetailsDao();
	private OrderDetail orderBook;

	public BuisnessImpl() {
		this.cart = new HashMap<Integer, OrderDetail>();
	}

	public ArrayList<Book> showBooks() {
		return bookDao.readAll();
	}

	public HashMap<Integer, String> showThemes() {
		return ((BookDao) bookDao).showThemes();
	}

	public ArrayList<Book> showBooksByTheme(Book book) {
		return ((BookDao) bookDao).readAllByTheme(book.getThematic()); // add cast
	}

	public void clearCart() {
		cart.clear();
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}

	public boolean addToCart(Book book, int orderQuantity) {
		OrderDetail orderBookDetail = cart.get(book.getBookId()); // ------------------------------
		if (orderBookDetail != null) {
			orderBookDetail.setQuantity(orderBook.getQuantity() + orderQuantity);
		} else {
			cart.put(orderBook.getOrderId(), orderBookDetail);
		}
		return orderDetailsDao.update(orderBook);
	}

	@Override
	public boolean deleteFromCart(Book book, int orderQuantity) {
		orderBook.setOrderId(book.getBookId());
		OrderDetail orderBook = cart.get(book.getBookId()); // -------------------
		int bookQuantity = orderBook.getQuantity();
		if (orderBook != null && orderQuantity <= bookQuantity)
			orderBook.setQuantity(bookQuantity - orderQuantity);
		return orderDetailsDao.update(orderBook);
	}

	public ArrayList<OrderDetail> getCart() {
		return new ArrayList<OrderDetail>(cart.values());
	}

	public int order(int userId) {
//		if (userDao.read(userId) != null) {
//			double[] total = { 0 };
//			cart.values().forEach((a) -> total[0] += a.getUnitaryPrice() * a.getQuantity());
//			Order order = new Order(new Date(), userId, total);
//			if (orderDao.create(order)) {
//// tester book
//
//				// unarityprice ou totalprice
//				for (OrderDetail orderDetail : cart.values()) {
//					orderDao.create(new OrderDetail(0, orderDetail.getProductId(), orderDetail.getQuantity(),
//							orderDetail.getUnitaryPrice(), orderDetail.getOrderId()));
//				}
//				return order.getOrderId();
//			}
//		}
		return 0;
	}

	public Book readBookFromId(int id) {
		return bookDao.read(id);
	}

	public int checkLogin(String email, String password) {
		for (Customer user : userDao.readAll())
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
				return user.getUserId();
		return 0;
	}

	@Override
	public ArrayList<Customer> showCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public double getTotal() {
		double[] total = { 0 };
		cart.values().forEach((a) -> total[0] += a.getUnitaryPrice() * a.getQuantity());
		return total[0];
	}

	@Override
	public ArrayList<Book> showBooks(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}