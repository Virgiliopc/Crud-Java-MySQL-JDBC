package main.br.com.agenda.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Contato {
	
	private int id;
	private String nome;
	private int idade;
	private Date dataCadastro;
	
	public void setDataCadastro(String dataCadastro) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataCadastro = dateFormat.parse(dataCadastro);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}	

}
