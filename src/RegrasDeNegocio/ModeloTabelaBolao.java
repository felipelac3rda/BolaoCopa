package RegrasDeNegocio;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Conexao.BolaoDAO;

public class ModeloTabelaBolao extends AbstractTableModel {

	ArrayList<Bolao> listaBoloes;
	BolaoDAO bolaodao;
	String[] colunas = { "Participante", "Placar Quarta", "Placar Semifinal", "Placar Final", "Campeão" };

	public ModeloTabelaBolao() {
		bolaodao = new BolaoDAO();
		listaBoloes = bolaodao.listar();
	}

	public String getColumnName(int column) {

		return colunas[column];
	}

	public int getRowCount() {

		return listaBoloes.size();
	}

	public int getColumnCount() {

		return colunas.length;
	}

	public Object getValueAt(int linhas, int colunas) {
		switch (colunas) {
		case 0:
			return listaBoloes.get(linhas).getNome();
		case 1:
			return listaBoloes.get(linhas).getSelecao1() + " " + listaBoloes.get(linhas).getGolsSelecao1() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao2() + " " + listaBoloes.get(linhas).getSelecao2() + "   "
					+ listaBoloes.get(linhas).getSelecao3() + " " + listaBoloes.get(linhas).getGolsSelecao3() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao4() + " " + listaBoloes.get(linhas).getSelecao4() + "   "
					+ listaBoloes.get(linhas).getSelecao5() + " " + listaBoloes.get(linhas).getGolsSelecao5() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao6() + " " + listaBoloes.get(linhas).getSelecao6() + "   "
					+ listaBoloes.get(linhas).getSelecao7() + " " + listaBoloes.get(linhas).getGolsSelecao7() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao8() + " " + listaBoloes.get(linhas).getSelecao8() + "   ";
		case 2:
			return listaBoloes.get(linhas).getSelecao9() + " " + listaBoloes.get(linhas).getGolsSelecao9() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao10() + " " + listaBoloes.get(linhas).getSelecao10() + "   "
					+ listaBoloes.get(linhas).getSelecao11() + " " + listaBoloes.get(linhas).getGolsSelecao11() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao12() + " " + listaBoloes.get(linhas).getSelecao12() + "   ";
		case 3:
			return listaBoloes.get(linhas).getSelecao13() + " " + listaBoloes.get(linhas).getGolsSelecao13() + " - "
					+ listaBoloes.get(linhas).getGolsSelecao14() + " " + listaBoloes.get(linhas).getSelecao14() + "   ";
		case 4:
			return listaBoloes.get(linhas).getSelecaovencedora();
		}
		return null;
	}

}
