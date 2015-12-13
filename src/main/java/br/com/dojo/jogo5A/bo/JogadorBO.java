package br.com.dojo.jogo5A.bo;

import java.util.Map.Entry;

import br.com.dojo.jogo5A.model.Jogador;
import br.com.dojo.jogo5A.repository.RepositorioJogador;

public class JogadorBO {

	public static void addAssassinato(RepositorioJogador repositorioJogador , String nomeJogador, String nomeArma) {
		if(repositorioJogador.getLista().get(nomeJogador) != null){
			JogadorBO.addAssassinato(nomeArma, repositorioJogador.getLista().get(nomeJogador));			
		} else {
			repositorioJogador.addJogador(new Jogador(nomeJogador));
			JogadorBO.addAssassinato(nomeArma, repositorioJogador.getLista().get(nomeJogador));
		}
	}
	
	public static void addAssassinato(String nomeArma,Jogador jogador) {
		jogador.getDadosPartida().setAssassinatos(jogador.getDadosPartida().getAssassinatos() + 1);
		addKillStreak(jogador);
		
		if( jogador.getDadosPartida().getArmasUsadas().get(nomeArma) != null ){
			jogador.getDadosPartida().getArmasUsadas().put(nomeArma, jogador.getDadosPartida().getArmasUsadas().get(nomeArma)	+ 1);
		} else {
			jogador.getDadosPartida().getArmasUsadas().put(nomeArma, 1);
		}

	}
	
	
	private static void addKillStreak(Jogador jogador) {
		jogador.getDadosPartida().setKillStreakAtual(jogador.getDadosPartida().getKillStreakAtual() + 1);
		
		if ( jogador.getDadosPartida().getKillStreakAtual() > jogador.getDadosPartida().getMaiorKillStreak() ){
			jogador.getDadosPartida().setMaiorKillStreak(jogador.getDadosPartida().getKillStreakAtual());
		}
	}

	

	public static void addMorte(RepositorioJogador repositorioJogador, String nomeJogador) {
		if(repositorioJogador.getLista().get(nomeJogador) != null){
			JogadorBO.addMorte(repositorioJogador.getLista().get(nomeJogador));
		} else {
			repositorioJogador.addJogador(new Jogador(nomeJogador));
			JogadorBO.addMorte(repositorioJogador.getLista().get(nomeJogador));
		}
	}
	
	public static void addMorte(Jogador jogador) {
		jogador.getDadosPartida().setMortes(jogador.getDadosPartida().getMortes() + 1);
		
		jogador.getDadosPartida().setKillStreakAtual(0);
	}
	
	
	public static void addAward(Jogador jogador) {
		jogador.getDadosPartida().setAwards(jogador.getDadosPartida().getAwards() + 1);
	}
	
	
	public static void atribuiAwards(RepositorioJogador repositorioJogador) {
		for(Entry<String, Jogador> jogador : repositorioJogador.getLista().entrySet()) {
		    if (jogador.getValue().getDadosPartida().getMortes() == 0) {		    	
		    	addAward(jogador.getValue());
		    }
		}
		
	}
	
	

	
	public static String getArmaPreferida(Jogador jogador){
		Entry<String, Integer> maiorNumeroAssassinatos = null;
		for(Entry<String, Integer> arma : jogador.getDadosPartida().getArmasUsadas().entrySet()) {
		    if (maiorNumeroAssassinatos == null || arma.getValue() > maiorNumeroAssassinatos.getValue()) {
		    	maiorNumeroAssassinatos = arma;
		    }
		}
		
		return maiorNumeroAssassinatos.getKey();
	}
	
}
