package br.com.ifes.ag;

import java.util.Random;

/**
* ricardobrasil
*/
public class FuncaoCruzamento implements Constantes {
	
	public static Individuo cruzamentoUmPonto(Individuo pai, Individuo mae) {
		Individuo filho = new Individuo();
		
		for(int i = 0; i < tamCromossomo; i++) {
			if ( i % 2 == 0) {				
				int pos = -1;
				for(int k=0;k<tamCromossomo;k++) {
					if(filho.cromossomo[k] == pai.cromossomo[i]) {
						pos = i;
					}
				}
				
				int anterior=filho.cromossomo[i] ;
				if ( pos == -1)
					filho.cromossomo[i] = mae.cromossomo[i];
				else {
					filho.cromossomo[anterior] = pai.cromossomo[i];
					filho.cromossomo[pos] = anterior;
				}
								
			} else {
				int pos = -1;
				for(int k=0;k<tamCromossomo;k++) {
					if(filho.cromossomo[k] == mae.cromossomo[i]) {
						pos = i;
					}
				}
				int anterior=filho.cromossomo[i] ;
				
				if ( pos == -1)
					filho.cromossomo[i] = mae.cromossomo[i];
				else {
					filho.cromossomo[anterior] = mae.cromossomo[i];
					filho.cromossomo[pos] = anterior;
				}
			}
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
