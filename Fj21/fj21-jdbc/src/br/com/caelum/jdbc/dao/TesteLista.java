package br.com.caelum.jdbc.dao;

import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;

public class TesteLista {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		for(Contato contato : contatos) {
			System.out.println("Nome: "+ contato.getNome() + "\n");
			System.out.println("Email: "+ contato.getEmail() + "\n");
			System.out.println("Endere�o: "+ contato.getEndereco() + "\n");
			System.out.println("Data de Nascimento: "+ contato.getDataNascimento().getTime() + "\n");
			System.out.println("--------------------------------------------------");
		}
	}

}
