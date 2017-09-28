package br.com.ifes.ag;
/**
* ricardobrasil
*/
public class Application {
	
	public static void main(String[] args) {
		// Gera populacao inicial P
		Populacao populacao = new Populacao(20, true);
		
		int geracao = 0;
		while ( populacao.getMelhorIndividuo().getAptidao() > 130) {
			// Cria espaco para populacao np
			Populacao novaPopulacao = new Populacao(20, false);
			
			// Elitismo
			Individuo melhorIndividuo = populacao.getMelhorIndividuo();
			novaPopulacao.individuos[0] = melhorIndividuo;
			
			for(int i = 1; i < populacao.getTamPopulacao()-1; i++) {
				// Faco o cruzamento
				Individuo pai = FuncaoSelecao.selecaoTorneio(populacao);
				Individuo mae = FuncaoSelecao.selecaoTorneio(populacao,pai);
				Individuo filho1 = FuncaoCruzamento.cruzamentoUmPonto(pai, mae);
				Individuo filho2 = FuncaoCruzamento.cruzamentoUmPonto(pai, mae);
				novaPopulacao.individuos[i] = filho1;
				novaPopulacao.individuos[i+1] = filho2;				
			}
			
			// Faco a mutacao
			for (int i = 0; i < novaPopulacao.getTamPopulacao(); i ++) {
				Individuo individuo = novaPopulacao.individuos[i];
				FuncaoMutacao.mutacao(individuo);
			}
			
			populacao = novaPopulacao;
			geracao += 1;
			System.out.println("Geracao: " + geracao + " melhor individuo " + populacao.getMelhorIndividuo() + " populacao " + novaPopulacao); 
			
		}
		System.out.println("Melhor Individuo: " + populacao.getMelhorIndividuo() +" aptidao " + populacao.getMelhorIndividuo().getAptidao());
	}
}
