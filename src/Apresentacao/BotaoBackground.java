package Apresentacao;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class BotaoBackground extends JButton {
	public BotaoBackground(String text) {
		setText(text);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(240, 30));
	}
}
