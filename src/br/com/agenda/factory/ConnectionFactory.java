package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome usuário do MySQL
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "";
	
	// Caminho database, porta e nome
	private static final String	 DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	/* Conexão com o database
	 * 
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		//Cria a conexão com o database
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//Recuperar uma conexão com database
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso!");
			con.close();
		}
	}

}
