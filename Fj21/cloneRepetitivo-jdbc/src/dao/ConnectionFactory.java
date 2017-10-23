package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.Connexao;
import modelo.Contato;

public class ConnectionFactory {
	
	private Connection conexao;
	
	public ConnectionFactory(){
		this.conexao = new Connexao().pegarConexao();
	}
	
	public void adicionar(Contato contato){
		
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getContato(){
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM CONTATOS");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			
			stmt.close();
			rs.close();
			return contatos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
