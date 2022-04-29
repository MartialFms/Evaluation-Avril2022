package fr.fms.app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.fms.business.BuisnessImpl;
import fr.fms.dao.BookDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.User;

public class App1 {
	private static Scanner scan = new Scanner(System.in);
	private static BuisnessImpl business = new BuisnessImpl();
	private static String userLogged = null;
	private static int connectedUser = 0;

	// displayArticles();

	public static void main(String[] args) {
		System.out.println("Etes vous client ou libraire ?\n[1] Client | [2] Libraire");
		int choice = 0;
		while (!scan.hasNextInt()) scan.next();
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				customerMenu();
				break;
			case 2:
				adminMenu();
				break;
			default:
				System.out.println("mauvaise saisie");
			}
		}

	
	

	public static void customerMenu() {
		System.out.println("Bonjour que souhaitez vous faire ?");
		System.out.println(
				"1/ Visualiser les livres | 2/ Ajouter au panier | 3/ Retirer du panier | 4/ Voir le panier | 5/ Finaliser la commander | 6/ Se connecter | 7/ Creer un compte");
		int choice = 0;
		boolean menu = true;
		while (menu == true) {
			while (!scan.hasNextInt()) scan.next();
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					displayBooks();
					break;
				case 2:
					addToCart();
					break;
				case 3:
					removeToCart();
					break;
				case 4:
					showCart();
					break;
				case 5:
					finalOrder();
					break;
				case 6:
					loginAccount();
					break;
				case 7:
					createAccount();
					break;
				case 8:
					System.out.println("à bientôt dans notre boutique :)");
					menu = false;
					break;
				default:
					System.out.println("mauvaise saisie");
				}
			}
		}
	

	public static void adminMenu() {
		System.out.println("Bonjour que souhaitez vous faire ?");
		int choice = 0;
		boolean menu = true;
		while (menu == true) {
			System.out.println(
					"1/ Ajouter une reference | 2/ Supprimer une reference | 3/ Modifier une reference | 4/ Ajouter un client | 5/ Supprimer un client | 6/ Passage en mode client");
			while (!scan.hasNextInt()) scan.next();
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					createBook();

					break;
				case 2:
					deleteBook();
					break;
				case 3:
					updateBook();
					break;
				case 4:
					createCustomer();
					break;
				case 5:
					deleteCustomer();
					break;
				case 6:
					System.out.println("Passage en mode client");
					menu = false;
					customerMenu();
					break;
				default:
					System.out.println("mauvaise saisie");
				}
			}
		}
	

	public static void displayBooks() {
		System.out.println("Afficher la liste :\n [1/ Complete ] [ 2/ Par theme ]");
		while (!scan.hasNextInt()) scan.next();
			int displayType = scan.nextInt();
		if (displayType == 1) {    
displayCompleteBooks();}
		else if (displayType == 2 ) { displayBooksByTheme();}
		else {System.out.println("Mauvaise saisie");}
	}
	
	public static void displayCompleteBooks() {
	ArrayList<Book> books = business.showBooks();
	books.forEach(b -> System.out.println(b.describe())) ;
	}

	public static void displayBooksByTheme() {
		System.out.println("Choisissez le theme");
		System.out.println(business.showThemes());
		int themeId = scan.nextInt();
		ArrayList<Book> bookList = business.showBooks();
		bookList.stream().filter(e -> e.getThematic() == themeId).forEach(e -> System.out.println(e.describe()));
	}

	public static void addToCart() {
		System.out.println("Saisissez le numero du livre à ajouter");
		displayCompleteBooks();
		while (!scan.hasNextInt()) scan.next();
			int bookId = scan.nextInt();
			Book addedBook = business.readBookFromId(bookId);
			System.out.println("Saisissez sa quantité à ajouter");
			int quantity = scan.nextInt();
			business.addToCart(addedBook, quantity);
		}
	

	public static void removeToCart() {
		System.out.println("Saisissez le numero du livre à supprimer");
		while (!scan.hasNextInt()) scan.next();
			int bookId = scan.nextInt();
			Book deletedBook = business.readBookFromId(bookId);
			System.out.println("Saisissez sa quantité à supprimer");
			int quantity = scan.nextInt();
			business.addToCart(deletedBook, quantity);
		}
	

	public static void showCart() {
		if (business.isCartEmpty())
			System.out.println("Votre panier est vide");
		else {
			System.out.println("Votre Panier :");
			business.getCart().forEach(a -> System.out.println(a.toString()));
		}
	}

	public static void finalOrder() {
				showCart();
				System.out.println("Votre commande s'éleve à  : " + business.getTotal());
				System.out.println("Souhaitez vous la valider ? [Oui/Non] :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					if(userLogged == null)	{ 
						System.out.println("Vous devez être connecté pour continuer");
						loginAccount();
					}
					if(userLogged != null) {
						int idOrder = business.order(connectedUser);
						if(idOrder == 0)	{System.out.println("Votre commande n'est pas validée.");}
						else {
							System.out.println("Votre commande a bien été validé, voici son numéro : " + idOrder);
							business.clearCart();
						}
					}
				}
			
		}

	public static void loginAccount() {
		if (userLogged != null)
			System.out.println("vous êtes déjà connecté");
		else {
			System.out.println("saisissez votre email : ");
			String email = scan.next();
			System.out.println("saisissez votre password : ");
			String password = scan.next();
			int userId = business.checkLogin(email, password);
			if (userId != 0) {
				userLogged = email;
				connectedUser = userId;
			} else
				System.out.println(
						"login ou password incorrect, voulez vous reesayer ou vous inscrire ?\n [ 1/ Reesayer] [ 2/ Creer un compte ]");
			int choice = 0;
			boolean menu = true;
			while (!scan.hasNextInt()) scan.next();
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					loginAccount();
					break;
				case 2:
					createCustomer();
					loginAccount();
					break;
				

			}
		}
	}

	public static void createAccount() {
		createCustomer();
	}

	public static void createBook() {
		System.out.println("Gestion de la creation d'une reference : ");
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
		BookDao creationDao = new BookDao();
		creationDao.create(book);
	}

	public static void updateBook() {
		// Questions
		System.out.println("Gestion de la mise à jour d'une reference : ");
		System.out.println("Entrez son Id : ");
		int targetId = scan.nextInt();
		BookDao updateDao = new BookDao();
		Book targetBook = updateDao.read(targetId);

		System.out.println("Modification du :\n[ 1/ Titre ] [ 2/ Auteur ] [ 3/ Theme ] [ 4/ Prix ]");
		int modify = 0;
		while (!scan.hasNextInt()) scan.next();
			modify = scan.nextInt();
			switch (modify) {
			case 1:
				System.out.println("Entrez son nouveau titre ?");
				String bookTitle = scan.next();
				targetBook.setTitle(bookTitle);
				break;
			case 2:
				System.out.println("Entrez son nouveau auteur : ");
				String bookAuthor = scan.next();
				targetBook.setAuthor(bookAuthor);
				break;
			case 3:
				System.out.println("Entrez son nouveau theme : ");
				int bookTheme = scan.nextInt();
				targetBook.setThematic(bookTheme);
				break;
			case 4:
				System.out.println("Entrez son nouveau prix : ");
				double bookPrice = scan.nextDouble();
				targetBook.setUnitaryPrice(bookPrice);
				break;
			default:
				System.out.println("Aucune modification faite");
			}
		

		updateDao.update(targetBook);
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

	public static void createCustomer() {
		// Questions
		System.out.println("Gestion de la creation d'utilisateur : ");
		Customer customer = new Customer();
		System.out.println("Entrez son nom");
		String firstName = scan.next();
		System.out.println("Entrez son prenom");
		String lastName = scan.next();
		System.out.println("Entrez son email");
		String email = scan.next();
		System.out.println("Entrez son telephone");
		String phone = scan.next();
		System.out.println("Entrez son adresse");
		String adress = scan.next();
		// Set object
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setAdress(adress);
		// Dao action
		UserDao customerDao = new UserDao();
		customerDao.create(customer);
	}

	public static void deleteCustomer() {
		// Questions
		System.out.println("Gestion de la suppression d'utilisateur : ");
		System.out.println("Entrez son id");
		int targetId = scan.nextInt();
		UserDao customerDao = new UserDao();
		Customer targetCustomer = customerDao.read(targetId);
		customerDao.delete(targetCustomer);
	}

}
