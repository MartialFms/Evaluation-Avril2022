package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.User;

public class UserDao implements Dao<Customer> {

	Connection connection = BddConnection.getConnection();

	@Override
	public boolean create(Customer customer) {
		try {
			String query = "INSERT INTO T_Custo (firstName, lastName, email, phone, adress) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, customer.getFirstName());
			prepStat.setString(2, customer.getLastName());
			prepStat.setString(3, customer.getEmail());
			prepStat.setString(4, customer.getPhone());
			prepStat.setString(5, customer.getAdress());
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
	public Customer read(int id) {
		String query = "SELECT * FROM T_Custo WHERE idCusto = ? ;";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setInt(1, id);
			ResultSet result = prepStat.executeQuery();
			if (result.next()) return new Customer(result.getInt(1), result.getString(2), result.getString(3),
					result.getString(4), result.getString(5), result.getString(6));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}

	@Override
	public boolean update(Customer customer) {
		// pas demandé par le client
		return false;
	}

	@Override
	public boolean delete(Customer customer) {
		// pas demandé par le client
		return false;
	}

	@Override
	public ArrayList<Customer> readAll() {
		ArrayList<Customer> customers  = new ArrayList<Customer>();
		String query = "SELECT * FROM T_Custo";
		try {
			PreparedStatement prepStat = connection.prepareStatement(query);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				int resultIdCusto = result.getInt(1);
				String resultFirstName = result.getString(2);
				String resultLastName = result.getString(3);
				String resultEmail = result.getString(4);
				String resultPhone = result.getString(5);
				String resultAdress = result.getString(6);
				customers.add((new Customer(resultIdCusto, resultFirstName, resultLastName, resultEmail, resultPhone, resultAdress)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

}