package br.com.ifes.ag.grid;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import br.com.ifes.ag.Application;
import br.com.ifes.ag.Constantes;

public class PainelGrid extends JPanel implements Constantes {

	private static final long serialVersionUID = 1L;
	private int contador;
	private GridBagConstraints gbc;
	
	public PainelGrid() {
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		JLabel jlabel;
		Grafo grafo;
		
		// Label cromossomo
		Celula celula = criarCelula(400, 50);
		jlabel = new JLabel("Melhor cromossomo");
		jlabel.setFont(new Font("Arial", 1, 22));
		celula.add(jlabel);

		
		// Cromossomos
		for(int i = 0; i < tamCidades; i++ ) {
			celula = criarCelula();
			if (Application.individuoAtual != null) { 
				jlabel = new JLabel(""+Application.individuoAtual.cromossomo[i]);
				jlabel.setFont(new Font("Arial", 1, 22));
				celula.add(jlabel);			
			}
		}
		
		// Label aptidao
		celula = criarCelula(200, 50);
		jlabel = new JLabel(" - aptidao - ");
		jlabel.setFont(new Font("Arial", 1, 22));
		celula.add(jlabel);
		
		// Aptidao
		celula = criarCelula();
		jlabel = new JLabel(""+Application.individuoAtual.getAptidao());
		jlabel.setFont(new Font("Arial", 1, 22));
		celula.add(jlabel);
		
	}
	
	public Celula criarCelula(int x, int y) {
		Celula celula = new Celula(x, y);
		celula.setBackground(Color.WHITE);
		Border border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
		celula.setBorder(border);
		
		contador += 1;
		
		gbc.gridx = contador;
		gbc.gridy = 0;
		add(celula, gbc);
		
		return celula;
	}
	
	public Celula criarCelula() {
		Celula celula = new Celula();
		celula.setBackground(Color.WHITE);
		Border border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
		celula.setBorder(border);
		
		contador += 1;
		
		gbc.gridx = contador;
		gbc.gridy = 0;
		add(celula, gbc);
		
		return celula;
	}
	
	
	
}
