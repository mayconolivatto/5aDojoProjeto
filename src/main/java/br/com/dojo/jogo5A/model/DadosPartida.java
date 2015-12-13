package br.com.dojo.jogo5A.model;

import java.util.HashMap;
import java.util.Map;

public class DadosPartida {
	private Integer assassinatos;
	private Integer mortes;
	private Integer killStreakAtual;
	private Integer maiorKillStreak;
	private Integer awards;
	private Map<String, Integer> armasUsadas;

	public DadosPartida() {
		armasUsadas = new HashMap<String, Integer>();
	}

	public Integer getAssassinatos() {
		return assassinatos;
	}

	public void setAssassinatos(Integer assassinatos) {
		this.assassinatos = assassinatos;
	}

	public Integer getMortes() {
		return mortes;
	}

	public void setMortes(Integer mortes) {
		this.mortes = mortes;
	}

	public Integer getKillStreakAtual() {
		return killStreakAtual;
	}

	public void setKillStreakAtual(Integer killStreakAtual) {
		this.killStreakAtual = killStreakAtual;
	}

	public Integer getMaiorKillStreak() {
		return maiorKillStreak;
	}

	public void setMaiorKillStreak(Integer maiorKillStreak) {
		this.maiorKillStreak = maiorKillStreak;
	}

	public Integer getAwards() {
		return awards;
	}

	public void setAwards(Integer awards) {
		this.awards = awards;
	}

	public Map<String, Integer> getArmasUsadas() {
		return armasUsadas;
	}

	public void setArmasUsadas(Map<String, Integer> armasUsadas) {
		this.armasUsadas = armasUsadas;
	}
}
