package Conexao;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "localhost";
		this.banco = "bolaocopa";
		this.usuario = "root";
		this.senha = "";
	}

	public Connection getConexao() {
		String url = "jdbc:mysql://" + this.host + "/" + this.banco + "?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conexão com MYSQL não realizada");
			ex.printStackTrace();
		}
		return null;
	}

}
