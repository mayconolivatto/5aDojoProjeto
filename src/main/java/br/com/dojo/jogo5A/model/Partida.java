package br.com.dojo.jogo5A.model;

import java.util.Date;
import java.util.Map.Entry;

import br.com.dojo.jogo5A.bo.JogadorBO;
import br.com.dojo.jogo5A.repository.RepositorioJogador;

public class Partida {

	private Date dataInicio;
	private Date dataFim;
	private String idPartida;
	private RepositorioJogador listaJogadores;
	
	public Partida(){
		 listaJogadores = new RepositorioJogador();
	}
	
	public Partida(String idPartida, Date dataInicio){
		this();
		this.setIdPartida(idPartida);
		this.setDataInicio(dataInicio);
	}
	
	public void addAssassinatoJogador(String nomeJogador, String nomeArma) {
		JogadorBO.addAssassinato(listaJogadores, nomeJogador, nomeArma);
	}

	public void addMorteJogador(String nomeJogador) {
		JogadorBO.addMorte(listaJogadores, nomeJogador);	
	}

	public void atribuiAwards() {
		JogadorBO.atribuiAwards(listaJogadores);		
	}

	public Entry<String, Jogador> getVencedor() {
		return listaJogadores.getVencedor();
	}

	public Entry<String, Jogador> getMaiorKillStreak() {
		return listaJogadores.getMaiorKillStreak();
	}

	
	public String getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(String idPartida) {
		this.idPartida = idPartida;
	}

	
	public Date getDataInicio() {
		return dataInicio;
	}

	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	
	public Date getDataFim() {
		return dataFim;
	}

	
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	
	public RepositorioJogador getListaJogadores() {
		return listaJogadores;
	}

	
	public void setListaJogadores(RepositorioJogador listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
}
