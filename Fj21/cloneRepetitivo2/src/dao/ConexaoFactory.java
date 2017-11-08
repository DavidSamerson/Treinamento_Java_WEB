package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import modelo.Contato;

public class ConexaoFactory {

	private Connection conexao;
	
	public ConexaoFactory(){
		this.conexao = new Conexao().pegarConexao();
	}
	
	public void adicionar(Contato contato){
		
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES (?,?,?,?)";
		
		try {
			
			PreparedStatement stmt =  conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
