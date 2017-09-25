package br.com.ifes.ag;

/**
* ricardobrasil
*/

public class Populacao {
	public Individuo[] individuos;

	public Populacao(int tam) {
		individuos = new Individuo[tam];
	}
	
	public Populacao(int tamPopulacao, boolean geracaoInicial) {
		individuos = new Individuo[tamPopulacao];
		for (int i = 0; i < tamPopulacao; i++) {
			Individuo individuo = new Individuo();
			individuo.gerarIndividuo();
			individuos[i] = individuo;				         
		}
	}

	public Individuo getMelhorIndividuo() {
		Individuo melhorIndividuo = individuos[0]; 
		for (int i = 0; i < getTamPopulacao(); i++) {
			if ( individuos[i].getAptidao() < melhorIndividuo.getAptidao()) { 
				melhorIndividuo = individuos[i];
			}
		}
		return melhorIndividuo;
	}

	public int getTamPopulacao() {
		return individuos.length;
	}
	
	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		for(int i = 0; i < getTamPopulacao(); i++) {
			st.append("[").append(individuos[i].toString()).append("]");
		}
		return st.toString();
	}
}
