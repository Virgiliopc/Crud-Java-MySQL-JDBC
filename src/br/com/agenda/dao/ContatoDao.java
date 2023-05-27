package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDao{

	/*
	 * CRUD (CREATE - READ - UPDATE - DELETE)
	 * 
	 */

	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o database
			conn = ConnectionFactory.createConnectionToMySQL();

			// Criação de uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar os valores esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			// Executar a query
			pstm.execute();
			System.out.println("Dados salvos com sucesso.");
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
	
	public void update (Contato contato) {
		String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? " + 
				"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar uma conexão com o database
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			//Qual o ID registro deseja atualizar
			pstm.setInt(4, contato.getId());
			// Executar a query
			pstm.execute();
			System.out.println("Dados atualizados com sucesso.");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar os dados: " + e.getMessage());
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

	public List<Contato> getContatos(){
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar dados do database
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				//Recuperar o Id
				contato.setId(rset.getInt("id"));
				//Recuperar o nome
				contato.setNome(rset.getString("nome"));
				//Recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				//Recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("dataCadastro"));
				contatos.add(contato);
			}	
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (rset != null) {
			            rset.close();
			        }
			        if (pstm != null) {
			            pstm.close();
			        }
			        
			        if(conn !=null) {
			        	conn.close();
			        }
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}			
			
			return contatos;				
		}
	}

