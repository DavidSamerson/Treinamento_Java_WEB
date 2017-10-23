package br.com.caelum.jdbc.dao;

import java.util.Calendar;

import br.com.caelum.jdbc.modelo.Contato;

public class TestaCadastro {

	public static void main(String[] args) {
	
		ContatoDao dao = new ContatoDao();
		
		for (int i = 0; i < 10000; i++) {
		
		Contato contato = new Contato();
		contato.setNome("David " + i);
		contato.setEmail("samerson"+i+"@gmail.com");
		contato.setEndereco("rua "+i+" barra do ceará");
		contato.setDataNascimento(Calendar.getInstance());
		
		dao.adiciona(contato);
		}
		
	}

}
