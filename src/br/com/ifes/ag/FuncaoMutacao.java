package br.com.ifes.ag;
/**
* ricardobrasil
*/
public class FuncaoMutacao implements Constantes {
	public static void mutacao(Individuo individuo) {
		for (int i = 0; i < tamCromossomo; i++) {
			byte r = (byte) Math.round(Math.random());
			individuo.cromossomo[i] = r;
		}
	}
}
