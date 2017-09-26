package br.com.ifes.ag;

import java.util.Random;

/**
* ricardobrasil
*/
public class FuncaoMutacao implements Constantes {
	public static void mutacao(Individuo individuo) {
		for (int i = 0; i < tamCromossomo; i++) {
			int range = tamCromossomo - 1 + 1;
			int r = new Random().nextInt(range) + 1;
			individuo.cromossomo[i] = r;
		}
	}
}
