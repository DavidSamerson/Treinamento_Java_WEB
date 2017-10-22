package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Connexao;
import modelo.Contato2;

public class Dao2 {
	
	Connection conexao;
	
	public Dao2(){
		conexao = new Connexao().pegarConexao();
	}
	
	public void Cadastrar(Contato2 contato){
		
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
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
