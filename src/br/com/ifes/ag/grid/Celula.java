package br.com.ifes.ag.grid;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Celula extends JPanel {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public Celula() {
		this.x = 50;
		this.y = 50;
	}
	
	public Celula(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(x, y);
    }    
}