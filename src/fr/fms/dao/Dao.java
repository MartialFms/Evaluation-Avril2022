package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

public interface Dao<T> {
	public Connection connection = BddConnection.getConnection();
	public static final Logger logger = Logger.getLogger("SqlExceptions");

	public boolean create(T obj);
	public T read(int id);
	public boolean update(T obj);
	public boolean delete(T obj);
	public ArrayList<T> readAll();

	
// ---------------- Base ---------------------------
//	public Connection connection = BddConnection.getConnection();
//	public void create(T obj) throws SQLException;
//	public void read(T obj) throws SQLException;
//	public void update(T obj); 
//	public void delete(T obj) throws SQLException;
//	public ArrayList<T> readAll() throws SQLException;

}



