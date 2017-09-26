package br.com.ifes.ag;

import java.util.Random;

/**
* ricardobrasil
*/
public class FuncaoCruzamento implements Constantes {
	
	public static Individuo cruzamentoUmPonto(Individuo pai, Individuo mae) {
		Individuo filho = new Individuo();
		
		for(int i = 0; i < tamCromossomo; i++) {
			filho.cromossomo[i] = pai.cromossomo[i];
		}
		
		for(int i = Math.round(tamCromossomo/2); i < tamCromossomo; i++) {
			if ( FuncaoAptidao.findLigacao(filho.cromossomo[i-1], mae.cromossomo[i]) != 999 &&
				 filho.contemCidade(mae.cromossomo[i]) == -1)
				filho.cromossomo[i] = pai.cromossomo[i];
		}
		
		return filho;
	}
	
	
	public static Individuo cruzamentoDoisPontos(Individuo pai, Individuo mae) {
		Individuo filho = new Individuo();
		// Seleciona o primeiro ponto de cruzamento entre 0 e n - 1
		int c1 = (int) Math.round( (Math.random() * tamCromossomo) );
		// Seleciona o segundo  ponto de cruzamento entre 0 e n - 1
		int c2 = (int) Math.round( (Math.random() * tamCromossomo) );
		
		for(int i = 0; i < tamCromossomo; i++) {
			filho.cromossomo[i] = 0;
		}
		
        for (int i = c1; i < c2; i++) {
        		filho.cromossomo[i] = 1;
        }
        return filho;
	}
}
