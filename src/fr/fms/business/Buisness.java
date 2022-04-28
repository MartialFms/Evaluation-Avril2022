package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Book;
import fr.fms.entities.Customer;


public interface Buisness {	

//	Dans un premier temps, l’application doitpermettre aux utilisateurs de 
//	visualiser l’ensemble des livres classés ou pas par thématiquespuis 
//	d’ajouter des livres à un panier, 
//	supprimer ou afficherson contenu puis passer commande, 
//	*il faudra 
//	vérifier que le client existe bien en base 
//	ou le créerpour passer commande, 
//	>> caractériséepar son id, montant total, date du jour, id du client associé.
	
	// Book order
	
	public ArrayList<Book> showBooks(Book book);
	
	public ArrayList<Book> showBooksByTheme(Book book);

	public boolean addToCart(Book book);		

	public boolean rmFromCart(Book book);		

	public ArrayList<Book> getCart();	
	
	public int order(int idUser);		
	
	// User present
	
	public ArrayList<Customer> showCustomers();

	public void addCustomer(Customer customer);
}