package br.com.ifes.ag;

import java.util.ArrayList;
import java.util.List;

import br.com.ifes.ag.matrix.Ligacao;
import br.com.ifes.ag.matrix.No;

/**
* ricardobrasil
*/
public class FuncaoAptidao implements Constantes {
	private static List<Ligacao> listaAdjacencia;
	static { 
		//      1    2     3     4      5 
		// 1   -1   100    35    -1     30 
		// 2   100  -1     25    -1     90
		// 3   35   25     -1    10     80
		// 4   -1   65     10    -1     50
		// 5   30  100     80    50     -1	
		
		listaAdjacencia = new ArrayList<>();
		No no1 = new No(1);
		No no2 = new No(2);
		No no3 = new No(3);
		No no4 = new No(4);
		No no5 = new No(5);
		listaAdjacencia.add(new Ligacao(no1, no2, 100));
		listaAdjacencia.add(new Ligacao(no1, no3, 35));
		listaAdjacencia.add(new Ligacao(no1, no5, 30));
		listaAdjacencia.add(new Ligacao(no2, no1, 100));
		listaAdjacencia.add(new Ligacao(no2, no3, 25));
		listaAdjacencia.add(new Ligacao(no2, no5, 90));
		listaAdjacencia.add(new Ligacao(no3, no1, 35));
		listaAdjacencia.add(new Ligacao(no3, no2, 25));
		listaAdjacencia.add(new Ligacao(no3, no4, 10));
		listaAdjacencia.add(new Ligacao(no3, no5, 80));
		listaAdjacencia.add(new Ligacao(no4, no2, 65));
		listaAdjacencia.add(new Ligacao(no4, no3, 10));
		listaAdjacencia.add(new Ligacao(no4, no5, 50));
		listaAdjacencia.add(new Ligacao(no5, no1, 30));
		listaAdjacencia.add(new Ligacao(no5, no2, 100));
		listaAdjacencia.add(new Ligacao(no5, no3, 80));
		listaAdjacencia.add(new Ligacao(no5, no4, 50));		
	}
	
	public static int calcular(Individuo cro) {
		int cidadeAtual = cro.cromossomo[0];
		int distanciaTotal = 0;
		for(int i = 1; i< tamCromossomo; i++) {
			int proximaCidade = cro.cromossomo[i];
			distanciaTotal += findLigacao(cidadeAtual, proximaCidade);
			
			cidadeAtual = proximaCidade;
		}
		
		return distanciaTotal;
	}
	
	
	public static int findLigacao(int num1, int num2) {
		for(Ligacao ligacao: listaAdjacencia) {
			if(ligacao.x.id == num1 && ligacao.y.id == num2) {
				return ligacao.dist;
			}
		}
		return 9999;
	}
}
