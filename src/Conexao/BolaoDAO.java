package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Apresentacao.Participante;
import RegrasDeNegocio.Bolao;

public class BolaoDAO {

	public void inserir(Bolao b) {
		Connection conexao = new Conexao().getConexao();
		String sql = "insert into bolao (nome, selecao1, selecao1gols, selecao2, selecao2gols"
				+ ", selecao3, selecao3gols, selecao4, selecao4gols"
				+ ", selecao5, selecao5gols, selecao6, selecao6gols" + ", selecao7, selecao7gols"
				+ ", selecao8, selecao8gols, selecao9, selecao9gols"
				+ ", selecao10, selecao10gols, selecao11, selecao11gols"
				+ ", selecao12, selecao12gols, selecao13, selecao13gols"
				+ ", selecao14, selecao14gols, selecaoganhadora)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement inserir = conexao.prepareStatement(sql);
			inserir.setString(1, b.nome);
			inserir.setString(2, b.selecao1);
			inserir.setInt(3, b.golsSelecao1);
			inserir.setString(4, b.selecao2);
			inserir.setInt(5, b.golsSelecao2);
			inserir.setString(6, b.selecao3);
			inserir.setInt(7, b.golsSelecao3);
			inserir.setString(8, b.selecao4);
			inserir.setInt(9, b.golsSelecao4);
			inserir.setString(10, b.selecao5);
			inserir.setInt(11, b.golsSelecao5);
			inserir.setString(12, b.selecao6);
			inserir.setInt(13, b.golsSelecao6);
			inserir.setString(14, b.selecao7);
			inserir.setInt(15, b.golsSelecao7);
			inserir.setString(16, b.selecao8);
			inserir.setInt(17, b.golsSelecao8);
			inserir.setString(18, b.selecao9);
			inserir.setInt(19, b.golsSelecao9);
			inserir.setString(20, b.selecao10);
			inserir.setInt(21, b.golsSelecao10);
			inserir.setString(22, b.selecao11);
			inserir.setInt(23, b.golsSelecao11);
			inserir.setString(24, b.selecao12);
			inserir.setInt(25, b.golsSelecao12);
			inserir.setString(26, b.selecao13);
			inserir.setInt(27, b.golsSelecao13);
			inserir.setString(28, b.selecao14);
			inserir.setInt(29, b.golsSelecao14);
			inserir.setString(30, b.selecaovencedora);

			inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Bolao> listar() {
		ArrayList<Bolao> aux = new ArrayList<Bolao>();
		Connection conexao = new Conexao().getConexao();
		try {

			ResultSet resultado = conexao.prepareStatement("select * from bolao").executeQuery();

			Bolao bolao;
			while (resultado.next()) {
				bolao = new Bolao();
				bolao.nome = resultado.getString("nome");
				bolao.selecao1 = resultado.getString("selecao1");
				bolao.golsSelecao1 = resultado.getInt("selecao1gols");
				bolao.selecao2 = resultado.getString("selecao2");
				bolao.golsSelecao2 = resultado.getInt("selecao2gols");
				bolao.selecao3 = resultado.getString("selecao3");
				bolao.golsSelecao3 = resultado.getInt("selecao3gols");
				bolao.selecao4 = resultado.getString("selecao4");
				bolao.golsSelecao4 = resultado.getInt("selecao4gols");
				bolao.selecao5 = resultado.getString("selecao5");
				bolao.golsSelecao5 = resultado.getInt("selecao5gols");
				bolao.selecao6 = resultado.getString("selecao6");
				bolao.golsSelecao6 = resultado.getInt("selecao6gols");
				bolao.selecao7 = resultado.getString("selecao7");
				bolao.golsSelecao7 = resultado.getInt("selecao7gols");
				bolao.selecao8 = resultado.getString("selecao8");
				bolao.golsSelecao8 = resultado.getInt("selecao8gols");
				bolao.selecao9 = resultado.getString("selecao9");
				bolao.golsSelecao9 = resultado.getInt("selecao9gols");
				bolao.selecao10 = resultado.getString("selecao10");
				bolao.golsSelecao10 = resultado.getInt("selecao10gols");
				bolao.selecao11 = resultado.getString("selecao11");
				bolao.golsSelecao11 = resultado.getInt("selecao11gols");
				bolao.selecao12 = resultado.getString("selecao12");
				bolao.golsSelecao12 = resultado.getInt("selecao12gols");
				bolao.selecao13 = resultado.getString("selecao13");
				bolao.golsSelecao13 = resultado.getInt("selecao13gols");
				bolao.selecao14 = resultado.getString("selecao14");
				bolao.golsSelecao14 = resultado.getInt("selecao14gols");
				bolao.selecaovencedora = resultado.getString("selecaoganhadora");
				aux.add(bolao);
			}
		} catch (Exception e) {

		}
		return aux;
	}

	public void adicionarNomeParticipante(String nome) {
		Connection conexao = new Conexao().getConexao();

		String sql = "insert into bolao (nome) values (?)";

		try {
			PreparedStatement inserir = conexao.prepareStatement(sql);
			inserir.setString(1, nome);

			inserir.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarResultadosQuartas(String nome, String selecao1, int placar1, String selecao2, int placar2,
			String selecao3, int placar3, String selecao4, int placar4, String selecao5, int placar5, String selecao6,
			int placar6, String selecao7, int placar7, String selecao8, int placar8) {
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement(
					"update bolao set selecao1 = ?, selecao1gols=?, selecao2 = ?, selecao2gols=?, selecao3 = ?, selecao3gols = ?, selecao4 = ?, selecao4gols = ?, selecao5 = ?, selecao5gols = ?, selecao6 = ?, selecao6gols = ?, selecao7 = ?, selecao7gols = ?, selecao8 = ?, selecao8gols = ? where nome = ?");

			up.setString(1, selecao1);
			up.setInt(2, placar1);
			up.setString(3, selecao2);
			up.setInt(4, placar2);
			up.setString(5, selecao3);
			up.setInt(6, placar3);
			up.setString(7, selecao4);
			up.setInt(8, placar4);
			up.setString(9, selecao5);
			up.setInt(10, placar5);
			up.setString(11, selecao6);
			up.setInt(12, placar6);
			up.setString(13, selecao7);
			up.setInt(14, placar7);
			up.setString(15, selecao8);
			up.setInt(16, placar8);
			up.setString(17, nome);
			up.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarResultadosSemi(String nome, String selecao1, int placar1, String selecao2, int placar2,
			String selecao3, int placar3, String selecao4, int placar4) {
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement(
					"update bolao set selecao9 = ?, selecao9gols = ?, selecao10 = ?, selecao10gols = ?, selecao11 = ?, selecao11gols = ?, selecao12 = ?, selecao12gols = ? where nome = ?");

			up.setString(1, selecao1);
			up.setInt(2, placar1);
			up.setString(3, selecao2);
			up.setInt(4, placar2);
			up.setString(5, selecao3);
			up.setInt(6, placar3);
			up.setString(7, selecao4);
			up.setInt(8, placar4);
			up.setString(9, nome);
			up.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarResultadosFinal(String nome, String selecao1, int placar1, String selecao2, int placar2) {
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement(
					"update bolao set selecao13 = ?, selecao13gols = ?, selecao14 = ?, selecao14gols = ? where nome = ?");

			up.setString(1, selecao1);
			up.setInt(2, placar1);
			up.setString(3, selecao2);
			up.setInt(4, placar2);
			up.setString(5, nome);
			up.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adicionarResultadosGanhador(String nome, String selecaoganhadora) {
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement up = conexao.prepareStatement("update bolao set selecaoganhadora = ? where nome = ?");

			up.setString(1, selecaoganhadora);
			up.setString(2, nome);
			up.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Bolao pegarSelecoesQualificadasParaSemi(String nomeParticipante) {
		Bolao b = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement resultado = conexao.prepareStatement("select * from bolao where nome = ?");

			resultado.setString(1, nomeParticipante);
			ResultSet resposta = resultado.executeQuery();

			while (resposta.next()) {
				b = new Bolao();
				b.setNome(resposta.getString("nome"));
				b.setSelecao1(resposta.getString("selecao1"));
				b.setSelecao2(resposta.getString("selecao2"));
				b.setSelecao3(resposta.getString("selecao3"));
				b.setSelecao4(resposta.getString("selecao4"));
				b.setSelecao5(resposta.getString("selecao5"));
				b.setSelecao6(resposta.getString("selecao6"));
				b.setSelecao7(resposta.getString("selecao7"));
				b.setSelecao8(resposta.getString("selecao8"));
				b.setGolsSelecao1(resposta.getInt("selecao1gols"));
				b.setGolsSelecao2(resposta.getInt("selecao2gols"));
				b.setGolsSelecao3(resposta.getInt("selecao3gols"));
				b.setGolsSelecao4(resposta.getInt("selecao4gols"));
				b.setGolsSelecao5(resposta.getInt("selecao5gols"));
				b.setGolsSelecao6(resposta.getInt("selecao6gols"));
				b.setGolsSelecao7(resposta.getInt("selecao7gols"));
				b.setGolsSelecao8(resposta.getInt("selecao8gols"));
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public Bolao pegarSelecoesQualificadasParaFinal(String nomeParticipante) {
		Bolao b = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement resultado = conexao.prepareStatement("select * from bolao where nome = ?");

			resultado.setString(1, nomeParticipante);
			ResultSet resposta = resultado.executeQuery();

			while (resposta.next()) {
				b = new Bolao();
				b.setNome(resposta.getString("nome"));
				b.setSelecao9(resposta.getString("selecao9"));
				b.setSelecao10(resposta.getString("selecao10"));
				b.setSelecao11(resposta.getString("selecao11"));
				b.setSelecao12(resposta.getString("selecao12"));
				b.setGolsSelecao9(resposta.getInt("selecao9gols"));
				b.setGolsSelecao10(resposta.getInt("selecao10gols"));
				b.setGolsSelecao11(resposta.getInt("selecao11gols"));
				b.setGolsSelecao12(resposta.getInt("selecao12gols"));
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public Bolao pegarSelecaoGanhadora(String nomeParticipante) {
		Bolao b = null;

		try {
			Connection conexao = new Conexao().getConexao();

			PreparedStatement resultado = conexao.prepareStatement("select * from bolao where nome = ?");

			resultado.setString(1, nomeParticipante);
			ResultSet resposta = resultado.executeQuery();

			while (resposta.next()) {
				b = new Bolao();
				b.setNome(resposta.getString("nome"));
				b.setSelecao13(resposta.getString("selecao13"));
				b.setSelecao14(resposta.getString("selecao14"));
				b.setGolsSelecao13(resposta.getInt("selecao13gols"));
				b.setGolsSelecao14(resposta.getInt("selecao14gols"));
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;

	}
}
