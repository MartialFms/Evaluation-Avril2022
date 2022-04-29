package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection {
	private volatile static Connection connection;		//1er verrou de gestion du multi threading
	private static String driver;
	private static String url;
	private static String login;
	private static String password;

	private BddConnection() {
		try {
			getConfigFile();
			Class.forName(driver);
			connection = DriverManager.getConnection(url,login,password);
		}			
		catch (SQLException e) {
			System.out.println("problème de connexion !" + e.getMessage());
		}
		catch (FileNotFoundException e) {
			System.out.println("Il faut générer le fichier de config avant de pouvoir l'utiliser !");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! A revoir !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public static synchronized Connection getConnection() {
		if(connection == null) 	new BddConnection();
		// else System.out.println("Connexion existe déjà ! " + connection.toString());
		return connection;
	}
	
	private static void getConfigFile() throws FileNotFoundException, IOException {
		Properties props = new Properties();		
		try (FileInputStream configFile = new FileInputStream("ressources/config.properties")){
			props.load(configFile);
		} catch (FileNotFoundException e) {
			System.out.println("Absence de config");
		} catch (IOException e) {
			System.out.println("Erreur lecture de config ! ");
		}
		
		driver = props.getProperty("db.driver");
		url = props.getProperty("db.url");
		login = props.getProperty("db.login");
		password = props.getProperty("db.password");
	}
}