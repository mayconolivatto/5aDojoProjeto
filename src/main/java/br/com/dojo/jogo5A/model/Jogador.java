package br.com.dojo.jogo5A.model;

public class Jogador {

	private String nomeJogador;
	private DadosPartida dadosPartida;

	public Jogador(String nomeJogador) {
		this.setNomeJogador(nomeJogador);
		this.dadosPartida = new DadosPartida();

		this.dadosPartida.setAssassinatos(0);
		this.dadosPartida.setMortes(0);
		this.dadosPartida.setKillStreakAtual(0);
		this.dadosPartida.setMaiorKillStreak(0);
		this.dadosPartida.setAwards(0);
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nickname) {
		this.nomeJogador = nickname;
	}

	public DadosPartida getDadosPartida() {
		return dadosPartida;
	}

	public void setDadosPartida(DadosPartida dadosPartida) {
		this.dadosPartida = dadosPartida;
	}
}
