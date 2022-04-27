package fr.fms.dao;

	import fr.fms.entities.Book;

	public class DaoFactory {
		
		public static Dao<Book> getBookDao() {
			return new BookDao();		
		}
		
		
	}

