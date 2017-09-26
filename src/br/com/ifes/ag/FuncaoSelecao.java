package br.com.ifes.ag;
/**
* ricardobrasil
*/
public class FuncaoSelecao implements Constantes {
	public static Individuo selecaoTorneio(Populacao pop) {
		Populacao torneio = new Populacao(tamTorneio);
        for (int i = 0; i < tamTorneio; i++) {
            int random = (int) (Math.random() * tamTorneio);           
            torneio.individuos[i] = pop.individuos[random];
        }
        Individuo melhorIndividuo = torneio.getMelhorIndividuo();
        return melhorIndividuo;
	}
}
