package br.com.ifes.ag;

import java.util.Random;

/**
 * ricardobrasil
 */
public class Individuo implements Constantes, Comparable<Individuo> {

	public int[] cromossomo = new int[tamCromossomo];

	private int aptidao;

	public Individuo() {
		this.aptidao = -1;
	}

	/*
	 * Crio o individuo aleatoriamente
	 */
	public void gerarIndividuo() {
		
		for(int i = 0; i < tamCromossomo; i++) {
			cromossomo[i] = -1;
		}
		int i = 0;
		while (i < tamCromossomo) {
			int range = tamCromossomo - 1 + 1;
			int b = new Random().nextInt(range) + 1;
			if ( contemCidade(b) == -1 ) {
				if ( i != 0 ) {
					if (FuncaoAptidao.findLigacao(cromossomo[i-1] , cromossomo[i]) != -1) {
						cromossomo[i] = b;
						i += 1;										
					}
				} else {
					cromossomo[i] = b;
					i += 1;															
				}
			}
		}
	}

	private int contemCidade(int b) {
		for(int i = 0; i < tamCromossomo; i++) {
			if(cromossomo[i] == b) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * Caso ainda nao tenha sido calculado a aptidao do indivuduo, eu chamo a funcao
	 */
	public int getAptidao() {
		if( aptidao == -1 ) 
			aptidao = FuncaoAptidao.calcular(this);
		return aptidao;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int b : cromossomo) {
			stringBuilder.append(b);
		}
		return stringBuilder.toString();
	}

	@Override
	public int compareTo(Individuo o) {
		if (this.getAptidao() > o.getAptidao())
			return 1;
		if (this.getAptidao() < o.getAptidao())
			return -1;
		return 0;

	}
	
	

}
