package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Book;
import fr.fms.entities.Order;

public class OrderDao implements Dao<Order> {

	Connection connection = BddConnection.getConnection();

	@Override
	public boolean create(Order order) {
		try {
			String query = "INSERT INTO T_Orders (Amount , IdCusto) VALUES (?,?);";
			PreparedStatement prepStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			{
				prepStat.setDouble(1, order.getOrderAmount());
				prepStat.setInt(2, order.getCustomerId());
				if (prepStat.executeUpdate() == 1)
					System.out.println("New Order created");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Creation Error !");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}