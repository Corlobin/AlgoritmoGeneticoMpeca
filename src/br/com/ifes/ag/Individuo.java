package br.com.ifes.ag;

/**
 * ricardobrasil
 */
public class Individuo implements Constantes, Comparable<Individuo> {

	public byte[] cromossomo = new byte[tamCromossomo];

	private int aptidao;

	public Individuo() {
		this.aptidao = -1;
	}

	/*
	 * Crio o individuo aleatoriamente
	 */
	public void gerarIndividuo() {
		int i = 0;
		while (i < tamCromossomo) {
			byte b = (byte) Math.round(Math.random());
			cromossomo[i] = b;
			i += 1;
		}
	}

	/*
	 * Caso ainda nao tenha sido calculado a aptidao do indivuduo, eu chamo a funcao
	 */
	public int getAptidao() {
		return aptidao == -1 ? FuncaoAptidao.calcular(this) : aptidao;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : cromossomo) {
			stringBuilder.append(b);
		}
		return stringBuilder.toString();
	}

	@Override
	public int compareTo(Individuo o) {
		if (this.getAptidao() > o.getAptidao())
			return 1;
		if (this.getAptidao() < o.getAptidao())
			return -1;
		return 0;

	}
	
	

}
