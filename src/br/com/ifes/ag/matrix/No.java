package br.com.ifes.ag.matrix;
/**
* ricardobrasil
*/
public class No {
	public static int idGlobal;	
	public int id;
	public String nomeEstado;
	public No( int id ) {
		this.id = id;
		No.idGlobal += 1;
	}
	public No( String estado ) {
		this.nomeEstado = estado;
	}
}
