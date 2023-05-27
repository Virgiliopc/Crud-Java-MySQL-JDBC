package br.com.agenda.aplicacao;

import java.util.Date;
import br.com.agenda.dao.ContatoDao;
import br.com.agenda.model.Contato;

public class Main {
	
	public static void main(String[] args) {
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome("João Guilherme");
		contato.setIdade(78);
		contato.setDataCadastro(new Date());
		
		//contatoDao.save(contato);
				
		//Deletar o contato peloo ID
		
		contatoDao.deleteByID(5);
		
		
		Contato c1 = new Contato();
		c1.setNome("João Dias");
		c1.setIdade(39);
		c1.setDataCadastro(new Date());
		c1.setId(5); // o número que que está no database da PK
		
		//contatoDao.update(c1);
		
		//Visualização dos dados do database
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+ c.getNome());
		}
	}

}
