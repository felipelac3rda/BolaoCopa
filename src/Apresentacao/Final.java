package Apresentacao;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Conexao.BolaoDAO;
import RegrasDeNegocio.Bolao;

public class Final extends JFrame {
	Bandeira bandeira;
	painelDeJogos jogo1;
	JButton inserirDados;
	String selecaoganhadora = "";
	String nomeParticipante;
	BolaoDAO bolaobanco;
	Bolao bolao;
	Bolao bolao2;

	public Final(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
		bolaobanco = new BolaoDAO();
		setSize(500, 130);
		setTitle("Final");
		organizarLayout();
		setResizable(false);
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new FlowLayout());
		jogo1 = new painelDeJogos();
		jogo1.getTextSelecao1().setEditable(false);
		jogo1.getTextSelecao2().setEditable(false);
		inserirDados = new JButton();
		inserirDados.setText("ENVIAR");
		inserirDados.setPreferredSize(new Dimension(500, 25));
		bolao = bolaobanco.pegarSelecoesQualificadasParaFinal(getNomeParticipante());

		escolherSelecoes();
		add(jogo1);
		add(inserirDados);
		inserirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarResultados();
				bolao2 = bolaobanco.pegarSelecaoGanhadora(getNomeParticipante());
				escolherSelecaoGanhadora();
				enviarResultadosGanhador();
				bandeira = new Bandeira(selecaoganhadora);
				setVisible(false);
			}
		});
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	private void enviarResultados() {
		bolaobanco = new BolaoDAO();
		bolaobanco.adicionarResultadosFinal(nomeParticipante, jogo1.getTextSelecao1().getText(),
				Integer.parseInt(jogo1.getTextPlacar1().getText()), jogo1.getTextSelecao2().getText(),
				Integer.parseInt(jogo1.getTextPlacar2().getText()));
	}

	private void enviarResultadosGanhador() {
		bolaobanco = new BolaoDAO();
		bolaobanco.adicionarResultadosGanhador(nomeParticipante, selecaoganhadora);
	}

	private void escolherSelecoes() {
		if (bolao.getGolsSelecao9() > bolao.getGolsSelecao10()) {
			jogo1.getTextSelecao1().setText(bolao.getSelecao9());
		} else {
			jogo1.getTextSelecao1().setText(bolao.getSelecao10());
		}
		if (bolao.getGolsSelecao11() > bolao.getGolsSelecao12()) {
			jogo1.getTextSelecao2().setText(bolao.getSelecao11());
		} else {
			jogo1.getTextSelecao2().setText(bolao.getSelecao12());
		}
	}

	private void escolherSelecaoGanhadora() {
		if (bolao2.getGolsSelecao13() > bolao2.getGolsSelecao14()) {
			selecaoganhadora = bolao2.selecao13;
		} else {
			selecaoganhadora = bolao2.selecao14;
		}
	}

}
