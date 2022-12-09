package Apresentacao;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Conexao.BolaoDAO;

public class Quartas extends JFrame {
	Semi semi;
	painelDeJogos jogo1;
	painelDeJogos jogo2;
	painelDeJogos jogo3;
	painelDeJogos jogo4;
	JButton inserirDados;
	BolaoDAO bolaobanco;
	String nomeParticipante;

	public Quartas(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
		setSize(500, 300);
		setTitle("Quartas de Final");
		organizarLayout();
		setResizable(false);
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new FlowLayout());
		jogo1 = new painelDeJogos();
		jogo2 = new painelDeJogos();
		jogo3 = new painelDeJogos();
		jogo4 = new painelDeJogos();
		inserirDados = new JButton();
		inserirDados.setText("ENVIAR");
		inserirDados.setPreferredSize(new Dimension(500, 25));
		add(jogo1);
		add(jogo2);
		add(jogo3);
		add(jogo4);
		add(inserirDados);
		inserirDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarResultados();
				semi = new Semi(nomeParticipante);
				setVisible(false);
			}
		});

	}

	private void enviarResultados() {
		bolaobanco = new BolaoDAO();
		bolaobanco.adicionarResultadosQuartas(nomeParticipante, jogo1.getTextSelecao1().getText(),
				Integer.parseInt(jogo1.getTextPlacar1().getText()), jogo1.getTextSelecao2().getText(),
				Integer.parseInt(jogo1.getTextPlacar2().getText()), jogo2.getTextSelecao1().getText(),
				Integer.parseInt(jogo2.getTextPlacar1().getText()), jogo2.getTextSelecao2().getText(),
				Integer.parseInt(jogo2.getTextPlacar2().getText()), jogo3.getTextSelecao1().getText(),
				Integer.parseInt(jogo3.getTextPlacar1().getText()), jogo3.getTextSelecao2().getText(),
				Integer.parseInt(jogo3.getTextPlacar2().getText()), jogo4.getTextSelecao1().getText(),
				Integer.parseInt(jogo4.getTextPlacar1().getText()), jogo4.getTextSelecao2().getText(),
				Integer.parseInt(jogo4.getTextPlacar2().getText()));
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

}
