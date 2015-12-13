package br.com.dojo.jogo5A.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.dojo.jogo5A.model.Jogador;

public class RepositorioJogador {
	private Map<String, Jogador> listaJogador;

	public RepositorioJogador() {
		listaJogador = new HashMap<String, Jogador>();
	}

	public void addJogador(Jogador jogador) {
		this.getLista().put(jogador.getNomeJogador(), jogador);
	}

	public Entry<String, Jogador> getVencedor() {
		Entry<String, Jogador> vencedor = null;
		for (Entry<String, Jogador> jogador : this.getLista().entrySet()) {
			if (vencedor == null || jogador.getValue().getDadosPartida().getAssassinatos() > vencedor.getValue()
					.getDadosPartida().getAssassinatos()) {
				vencedor = jogador;
			}
		}

		return vencedor;
	}

	public Entry<String, Jogador> getMaiorKillStreak() {
		Entry<String, Jogador> maiorKillStreak = null;

		for (Entry<String, Jogador> jogador : this.getLista().entrySet()) {
			if (maiorKillStreak == null || jogador.getValue().getDadosPartida().getMaiorKillStreak() > maiorKillStreak
					.getValue().getDadosPartida().getMaiorKillStreak()) {
				maiorKillStreak = jogador;
			}
		}

		return maiorKillStreak;
	}

	/**
	 * @return the listaJogadores
	 */
	public Map<String, Jogador> getLista() {
		return listaJogador;
	}
}
