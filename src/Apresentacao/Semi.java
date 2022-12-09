package Apresentacao;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Conexao.BolaoDAO;
import Conexao.Conexao;
import RegrasDeNegocio.Bolao;

public class Semi extends JFrame {
	Bolao bolao;
	Final finall;
	painelDeJogos jogo1;
	painelDeJogos jogo2;
	JButton inserirDados;
	String nomeParticipante;
	BolaoDAO bolaobanco;

	public Semi(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
		bolaobanco = new BolaoDAO();
		setSize(500, 185);
		setTitle("SemiFinal");
		organizarLayout();
		setResizable(false);
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new FlowLayout());
		jogo1 = new painelDeJogos();
		jogo2 = new painelDeJogos();
		jogo1.getTextSelecao1().setEditable(false);
		jogo1.getTextSelecao2().setEditable(false);
		jogo2.getTextSelecao1().setEditable(false);
		jogo2.getTextSelecao2().setEditable(false);
		inserirDados = new JButton();
		inserirDados.setText("ENVIAR");
		inserirDados.setPreferredSize(new Dimension(500, 25));
		bolao = bolaobanco.pegarSelecoesQualificadasParaSemi(getNomeParticipante());
		escolherSelecoes();
		add(jogo1);
		add(jogo2);
		add(inserirDados);
		inserirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarResultados();
				finall = new Final(nomeParticipante);
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
		bolaobanco.adicionarResultadosSemi(nomeParticipante, jogo1.getTextSelecao1().getText(),
				Integer.parseInt(jogo1.getTextPlacar1().getText()), jogo1.getTextSelecao2().getText(),
				Integer.parseInt(jogo1.getTextPlacar2().getText()), jogo2.getTextSelecao1().getText(),
				Integer.parseInt(jogo2.getTextPlacar1().getText()), jogo2.getTextSelecao2().getText(),
				Integer.parseInt(jogo2.getTextPlacar2().getText()));
	}

	private void escolherSelecoes() {
		if (bolao.getGolsSelecao1() > bolao.getGolsSelecao2()) {
			jogo1.getTextSelecao1().setText(bolao.getSelecao1());
		} else {
			jogo1.getTextSelecao1().setText(bolao.getSelecao2());
		}
		if (bolao.getGolsSelecao3() > bolao.getGolsSelecao4()) {
			jogo1.getTextSelecao2().setText(bolao.getSelecao3());
		} else {
			jogo1.getTextSelecao2().setText(bolao.getSelecao4());
		}
		if (bolao.getGolsSelecao5() > bolao.getGolsSelecao6()) {
			jogo2.getTextSelecao1().setText(bolao.getSelecao5());
		} else {
			jogo2.getTextSelecao1().setText(bolao.getSelecao6());
		}
		if (bolao.getGolsSelecao7() > bolao.getGolsSelecao8()) {
			jogo2.getTextSelecao2().setText(bolao.getSelecao7());
		} else {
			jogo2.getTextSelecao2().setText(bolao.getSelecao8());
		}

	}

}
