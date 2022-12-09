package Apresentacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Background extends JFrame {
	JLabel funcionalidades;
	BotaoBackground botaoCadastrar;
	BotaoBackground botaoMostrar;
	BotaoBackground botaoImportar;
	BotaoBackground botaoExportar;
	Participante cadastrar;
	Mostrar mostrar;

	public Background() {
		cadastrar = new Participante();
		organizarLayout();
		criarBotoes();

	}

	private void organizarLayout() {
		setSize(322, 238);
		setLayout(new FlowLayout());
		funcionalidades = new JLabel("Funcionalidades do Bol�o");
		funcionalidades.setPreferredSize(new Dimension(150, 30));
		add(funcionalidades);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	private void criarBotoes() {
		botaoCadastrar = new BotaoBackground("Cadastrar novo Bol�o");
		botaoMostrar = new BotaoBackground("Mostrar Bol�es Cadastrados");
		botaoImportar = new BotaoBackground("Importar Bol�es");
		botaoExportar = new BotaoBackground("Exportar Bol�es");
		add(botaoCadastrar);
		add(botaoMostrar);
		add(botaoImportar);
		add(botaoExportar);
		botaoCadastrar.addActionListener(cadastrar);
		botaoMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar = new Mostrar();
			}
		});
	}
}
