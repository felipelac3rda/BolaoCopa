package Apresentacao;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bandeira extends JFrame {
	BufferedImage img;
	String selecaoGanhadora;

	public Bandeira(String selecaoGanhadora) {
		setSize(480, 400);
		this.selecaoGanhadora = selecaoGanhadora;
		setTitle("Seleção Campeã Segundo o Palpite do Participante");
		organizarBack();
		setResizable(false);
		setVisible(true);
	}

	private void organizarBack() {
		try {
			if (selecaoGanhadora.equals("BRA")) {
				img = ImageIO.read(new File("imgs\\brazil.png"));
			} else if (selecaoGanhadora.equals("HOL")) {
				img = ImageIO.read(new File("imgs\\holanda.png"));
			} else if (selecaoGanhadora.equals("ESP")) {
				img = ImageIO.read(new File("imgs\\espanha.jpg"));
			} else if (selecaoGanhadora.equals("ARG")) {
				img = ImageIO.read(new File("imgs\\argentina.jpg"));
			} else if (selecaoGanhadora.equals("CRO")) {
				img = ImageIO.read(new File("imgs\\croacia.png"));
			} else if (selecaoGanhadora.equals("FRA")) {
				img = ImageIO.read(new File("imgs\\franca.png"));
			} else if (selecaoGanhadora.equals("POR")) {
				img = ImageIO.read(new File("imgs\\portugal.png"));
			} else {
				img = ImageIO.read(new File("imgs\\inglaterra.jpg"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel l = new JLabel();

		Image dimg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageicon = new ImageIcon(dimg);
		l.setIcon(imageicon);
		add(l);
	}
}
