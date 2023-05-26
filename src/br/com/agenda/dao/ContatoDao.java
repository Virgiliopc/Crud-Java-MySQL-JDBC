package br.com.agenda.dao;

import java.sql.Connection;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDao {
	
	/* CRUD (CREATE - READ - UPDATE - DELETE)
	 * 
	 */
	
	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//Criar uma conexão com o database
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criação de uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new java.sql.Date(contato.getDataCadastro().getTime()));
			//Executar a query
			pstm.execute();
			System.out.println("Dados inseridos com sucesso.");
		} catch (Exception e) {
			System.out.println("Erro ao inserir dados: " + e.getMessage());
		} finally {
			try {
		        if (pstm != null) {
		            pstm.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	}
}
