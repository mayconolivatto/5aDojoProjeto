package br.com.dojo.jogo5A.util;

import java.util.List;
import java.util.Map.Entry;

import br.com.dojo.jogo5A.bo.JogadorBO;
import br.com.dojo.jogo5A.model.Jogador;
import br.com.dojo.jogo5A.model.Partida;

public class DojoUltil {
	public static void imprimirDadosPartida(List<Partida> partidas) {
		for (Partida partida : partidas) {
			System.out.println("Partida " + partida.getIdPartida() + ":");
			imprimeDadosJogadorAtual(partida);
			imprimeDadosVencedor(partida);

		}
	}

	private static void imprimeDadosVencedor(Partida partida) {

		System.out.println("Vencedor: " + partida.getVencedor().getKey() + " | Arma preferida: "
				+ JogadorBO.getArmaPreferida(partida.getVencedor().getValue()));

		System.out.println(
				"Maior kill streak: " + partida.getMaiorKillStreak().getValue().getDadosPartida().getMaiorKillStreak()
						+ " | Feito por: " + partida.getMaiorKillStreak().getValue().getNomeJogador());

		System.out.println("");
		System.out.println("");
	}

	private static void imprimeDadosJogadorAtual(Partida partida) {
		Jogador jogadorAtual;
		for (Entry<String, Jogador> itemLista : partida.getListaJogadores().getLista().entrySet()) {
			jogadorAtual = itemLista.getValue();

			System.out.println("- Jogador: " + itemLista.getKey());
			System.out.println("- Assassinatos: " + jogadorAtual.getDadosPartida().getAssassinatos());
			System.out.println("- Mortes: " + jogadorAtual.getDadosPartida().getMortes());
			System.out.println("- Awards: " + jogadorAtual.getDadosPartida().getAwards());

			System.out.println("");
		}
	}
}
