package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection abrirConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21db", "root", "");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void fecharConexao(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("-- Conexão fechada --");
			} catch (SQLException e) {
				System.out.println("Erro ao fechar a conexão.");
				e.printStackTrace();
			}
		}
	}
	
	public static void fecharConexao(Connection connection, PreparedStatement stmt) {
		fecharConexao(connection);
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar o Prepared Statement.");
                e.printStackTrace();
			}
		}
	}
	
	public static void fecharConexao(Connection connection, PreparedStatement stmt, ResultSet rs) {
		fecharConexao(connection, stmt);
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar o ResultSet.");
                e.printStackTrace();
			}
		}
	}
}