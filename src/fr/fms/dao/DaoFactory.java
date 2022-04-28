package fr.fms.dao;

	import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;

	public class DaoFactory {
		
		public static Dao<Book> getBookDao() {
			return new BookDao();		
		}
		
		public static Dao<Customer> getUserDao() {
			return new UserDao();		
		}
		
		public static Dao<Order> getOrderDao() {
			return new OrderDao();		
		}
		
		public static Dao<OrderDetail> getOrderDetailsDao() {
			return new OrderDetailsDao();		
		}
		
		
	}

