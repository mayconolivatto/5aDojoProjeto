package br.com.dojo.jogo5A.main;

import br.com.dojo.jogo5A.log.LogPartida;
import br.com.dojo.jogo5A.util.DojoUltil;

public class Principal {
	public static void main(String [] args){	
		DojoUltil.imprimirDadosPartida(LogPartida.lerLog("logpartida.log"));
	}
	
}
