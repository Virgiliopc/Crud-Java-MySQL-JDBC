package main.br.com.agenda.aplicacao;

import java.util.Date;
import main.br.com.agenda.dao.ContatoDao;
import main.br.com.agenda.model.Contato;

public class Main {
	
	public static void main(String[] args) {
		ContatoDao contatoDao = new ContatoDao();
		
		//Cadastro de novo Contato
		Contato contato = new Contato();
		contato.setNome("João Vicente");
		contato.setIdade(54);
		contato.setDataCadastro(new Date());
		
		contatoDao.save(contato);
				
		//Deletar o contato pelo ID		
		contatoDao.deleteByID(7);
		
		// Update do Contato
		Contato c1 = new Contato();
		c1.setNome("João Guilherme de Souza");
		c1.setIdade(39);
		c1.setDataCadastro(new Date());
		c1.setId(6); // o número que que está no database da PK
		
		contatoDao.update(c1);
		
		//Visualização dos dados do database		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+ c.getNome());
		}
	}

}
