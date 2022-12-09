package Apresentacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class painelDeJogos extends JPanel {

	JLabel selecao1;
	JLabel selecao2;
	JLabel placar1;
	JLabel placar2;
	JTextField textSelecao1;
	JTextField textPlacar1;
	JTextField textSelecao2;
	JTextField textPlacar2;

	public painelDeJogos() {
		setPreferredSize(new Dimension(500, 52));
		organizarLayout();
	}

	private void organizarLayout() {
		setLayout(new FlowLayout());
		selecao1 = new JLabel();
		selecao2 = new JLabel();
		placar1 = new JLabel();
		placar2 = new JLabel();
		textSelecao1 = new JTextField();
		textPlacar1 = new JTextField();
		textSelecao2 = new JTextField();
		textPlacar2 = new JTextField();
		selecao1.setText("Seleção:");
		placar1.setText("Placar:");
		selecao2.setText("    X     Seleção:");
		placar2.setText("Placar:");
		textSelecao1.setPreferredSize(new Dimension(80, 30));
		textSelecao2.setPreferredSize(new Dimension(80, 30));
		textPlacar1.setPreferredSize(new Dimension(30, 30));
		textPlacar2.setPreferredSize(new Dimension(30, 30));
		add(selecao1);
		add(textSelecao1);
		add(placar1);
		add(textPlacar1);
		add(selecao2);
		add(textSelecao2);
		add(placar2);
		add(textPlacar2);
	}

	public JLabel getPlacar1() {
		return placar1;
	}

	public JLabel getSelecao1() {
		return selecao1;
	}

	public JLabel getSelecao2() {
		return selecao2;
	}

	public JLabel getPlacar2() {
		return placar2;
	}

	public JTextField getTextSelecao1() {
		return textSelecao1;
	}

	public JTextField getTextPlacar1() {
		return textPlacar1;
	}

	public JTextField getTextSelecao2() {
		return textSelecao2;
	}

	public JTextField getTextPlacar2() {
		return textPlacar2;
	}

}
