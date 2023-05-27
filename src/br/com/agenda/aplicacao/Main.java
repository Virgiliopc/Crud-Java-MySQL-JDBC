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
		
		contatoDao.save(contato);
		
		//Visualização dos dados do database
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+ c.getNome());
		}
	}

}
