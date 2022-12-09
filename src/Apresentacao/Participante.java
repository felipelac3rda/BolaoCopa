package Apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Conexao.BolaoDAO;

public class Participante extends JFrame implements ActionListener {
	Quartas quartas;
	JPanel superior;
	JPanel inferior;
	JPanel esquerda;
	JPanel direita;
	JLabel nomeTela;
	JLabel nomeParticipante;
	JTextField inserirNome;
	BotaoBackground botaoInserirNome;
	BolaoDAO bolaobanco;

	public Participante() {
		setSize(430, 210);
		bolaobanco = new BolaoDAO();
		organizarLayout();
		setResizable(false);
		setVisible(false);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());
		superior = new JPanel();
		superior.setPreferredSize(new Dimension(430, 40));
		inferior = new JPanel();
		inferior.setPreferredSize(new Dimension(430, 132));
		nomeTela = new JLabel("Informação do Participante do Bolão");
		superior.add(nomeTela);
		organizarInferior();
		add(superior, BorderLayout.NORTH);
		add(inferior, BorderLayout.SOUTH);
	}

	private void organizarInferior() {
		inferior.setLayout(new BorderLayout());
		esquerda = new JPanel();
		direita = new JPanel();
		nomeParticipante = new JLabel("Nome:");
		esquerda.setBorder(BorderFactory.createLineBorder(Color.WHITE, 27));
		esquerda.add(nomeParticipante);
		organizarDireita();
		inferior.add(esquerda, BorderLayout.WEST);
		inferior.add(direita, BorderLayout.EAST);

	}

	private void organizarDireita() {
		direita.setLayout(new BorderLayout());
		direita.setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
		inserirNome = new JTextField();
		botaoInserirNome = new BotaoBackground("INSERIR");
		inserirNome.setBackground(new Color(169, 169, 169));
		inserirNome.setPreferredSize(new Dimension(200, 40));
		inserirNome.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		direita.add(inserirNome, BorderLayout.NORTH);
		direita.add(botaoInserirNome, BorderLayout.SOUTH);
		botaoInserirNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quartas = new Quartas(inserirNome.getText());
				bolaobanco.adicionarNomeParticipante(inserirNome.getText());
				inserirNome.setText("");
				setVisible(false);
			}
		});

	}

	public void actionPerformed(ActionEvent arg0) {
		setVisible(true);
	}

	public JTextField getInserirNome() {
		return inserirNome;
	}

}
