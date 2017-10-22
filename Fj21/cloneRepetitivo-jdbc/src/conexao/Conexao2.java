package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao2 {
	public Connection PegarMinhaConexao(){
			try {
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/fj21", "root", "12345");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
