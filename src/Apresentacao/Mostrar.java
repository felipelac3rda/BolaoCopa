package Apresentacao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import RegrasDeNegocio.ModeloTabelaBolao;

public class Mostrar extends JFrame {

	ModeloTabelaBolao modeloTabela;
	JTable jTBolao;
	JPanel painel;

	public Mostrar() {
		setSize(590, 330);
		setTitle("Tabela dos Bolões");
		painel = new JPanel();
		modeloTabela = new ModeloTabelaBolao();
		jTBolao = new JTable(modeloTabela);
		JScrollPane scroll = new JScrollPane(jTBolao);
		jTBolao.setPreferredScrollableViewportSize(new Dimension(550, 245));
		jTBolao.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTBolao.getColumnModel().getColumn(1).setPreferredWidth(360);
		jTBolao.getColumnModel().getColumn(2).setPreferredWidth(190);
		jTBolao.getColumnModel().getColumn(3).setPreferredWidth(100);
		painel.add(scroll);
		add(painel);
		setResizable(false);
		setVisible(true);
	}
}
