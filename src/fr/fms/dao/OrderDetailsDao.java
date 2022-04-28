package fr.fms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import fr.fms.entities.Book;
import fr.fms.entities.OrderDetail;

public class OrderDetailsDao implements Dao<OrderDetail> {

	Connection connection = BddConnection.getConnection();

	@Override
	public boolean create(OrderDetail orderDetail) {
		try {
			String query = "INSERT INTO T_Order_Details (BookId, Quantity, UnitaryPrice, OrderId) VALUES (?,?,?,?);";
			PreparedStatement prepStat = connection.prepareStatement(query);
			prepStat.setString(1, orderDetail.getProductId());
			prepStat.setInt(2, orderDetail.getQuantity());
			prepStat.setDouble(3, orderDetail.getUnitaryPrice());
			prepStat.setDouble(4, orderDetail.getOrderId());
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
	public OrderDetail read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderDetail obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderDetail obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderDetail> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


}