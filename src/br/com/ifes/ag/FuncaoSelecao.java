package br.com.ifes.ag;

import java.util.Random;

/**
* ricardobrasil
*/
public class FuncaoSelecao implements Constantes {
	private static Random generator = new Random();
	public static Individuo selecaoTorneio(Populacao pop) {
		Populacao torneio = new Populacao(tamTorneio, false);
        for (int i = 0; i < tamTorneio; i++) {
            int rand = randInt(1, tamTorneio-1);
            torneio.individuos[i] = pop.individuos[rand];
        }
        Individuo melhorIndividuo = torneio.getMelhorIndividuo();
        return melhorIndividuo;
	}
	
	public static Individuo selecaoTorneio(Populacao pop, Individuo pai) {
		Populacao torneio = new Populacao(tamTorneio, false);
        for (int i = 0; i < tamTorneio; i++) {
            int rand = randInt(1, tamTorneio-1);
            if ( pop.individuos[rand] == pai) 
            		continue;
            torneio.individuos[i] = pop.individuos[rand];
        }
        Individuo melhorIndividuo = torneio.getMelhorIndividuo();
        return melhorIndividuo;
	}

	
	public static int randInt(int min, int max) {
	    int randomNum = generator.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
