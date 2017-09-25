package br.com.ifes.ag;
/**
* ricardobrasil
*/
public class FuncaoCruzamento implements Constantes {
	
	public static Individuo cruzamentoUmPonto(Individuo pai, Individuo mae) {
		Individuo filho = new Individuo();
		// Seleciona o primeiro ponto de cruzamento entre 0 e n - 1
		int c1 = (int) Math.round( (Math.random() * tamCromossomo) );
		
		for(int i = 0; i < tamCromossomo; i++) {
			filho.cromossomo[i] = 0;
		}
		
        for (int i = c1; i < tamCromossomo; i++) {
        		filho.cromossomo[i] = 1;
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
