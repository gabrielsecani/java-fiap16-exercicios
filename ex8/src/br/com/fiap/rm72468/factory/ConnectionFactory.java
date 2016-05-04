package br.com.fiap.rm72468.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.jdbc.log.Log;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException{
		System.out.println("Abrindo mysql.jdbc.Driver");
		try {
			   Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException ex){ }
		
		String server = "localhost";
		String database = "ex8";
				
		String url = "jdbc:mysql://" + server + "/" + database;
		String user = "root";
		String senha = "1234";

		System.out.println("Carregando conexão");

		Connection conn = DriverManager.getConnection(url, user, senha);
		System.out.println("Ok.");

		return conn;
	}
	
}
