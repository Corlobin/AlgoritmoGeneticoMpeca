package br.com.ifes.ag.grid;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Grafo extends JPanel {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	public Grafo() {
		this.x = 300;
		this.y = 200;
	}

	public Grafo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(x, y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		this.setBackground(Color.white);
		Border border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
		this.setBorder(border);

		g.drawLine(5, 30, 380, 30);

		g.setColor(Color.BLUE);
		g.drawRect(5, 40, 90, 55);
		g.fillRect(100, 40, 90, 55);

		g.setColor(Color.CYAN);
		g.fillRoundRect(195, 40, 90, 55, 50, 50);
		g.drawRoundRect(290, 40, 90, 55, 20, 20);

		g.setColor(Color.YELLOW);
		g.draw3DRect(5, 100, 90, 55, true);
		g.fill3DRect(100, 100, 90, 55, false);

		g.setColor(Color.MAGENTA);
		g.drawOval(195, 100, 90, 55);
		g.fillOval(290, 100, 90, 55);

	}

}