package br.com.ifes.ag;
/**
* ricardobrasil
*/
public class Application {
	
	public static void main(String[] args) {
		// Gera populacao inicial P
		Populacao populacao = new Populacao(10, true);
		
		int geracao = 0;
		while ( geracao <= 30) {
			// Cria espaco para populacao np
			Populacao novaPopulacao = new Populacao(10, false);
			for(int i = 0; i < populacao.getTamPopulacao(); i++) {
				// Faco o cruzamento
				Individuo pai = FuncaoSelecao.selecaoTorneio(populacao);
				Individuo mae = FuncaoSelecao.selecaoTorneio(populacao);
				Individuo filho = FuncaoCruzamento.cruzamentoUmPonto(pai, mae);
				novaPopulacao.individuos[i] = filho;
			}
			
			// Faco a mutacao
			for (int i = 0; i < novaPopulacao.getTamPopulacao(); i ++) {
				Individuo individuo = novaPopulacao.individuos[i];
				FuncaoMutacao.mutacao(individuo);
			}
			
			populacao = novaPopulacao;
			geracao += 1;
			System.out.println("Geracao: " + geracao); 
			System.out.println("Melhor Individuo: " + populacao.getMelhorIndividuo());
		}
	}
}
