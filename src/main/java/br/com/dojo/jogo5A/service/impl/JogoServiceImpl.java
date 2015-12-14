package br.com.dojo.jogo5A.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.dojo.jogo5A.bo.JogadorBO;
import br.com.dojo.jogo5A.model.Jogador;
import br.com.dojo.jogo5A.model.Partida;
import br.com.dojo.jogo5A.service.JogoService;
import br.com.dojo.jogo5A.vo.DadosPartidaVo;
import br.com.dojo.jogo5A.vo.PartidaVo;


public class JogoServiceImpl implements JogoService {

	
	private  List<PartidaVo> imprimirDadosPartida(List<Partida> partidas) {
		List<PartidaVo> listaPartidaVo = new ArrayList<PartidaVo>();
		for (Partida partida : partidas) {
		 PartidaVo partidaVo = new PartidaVo();
		 	partidaVo.setPartida(partida.getIdPartida());
			System.out.println("Partida " + partida.getIdPartida() + ":");
			imprimeDadosJogadorAtual(partida,partidaVo);
			imprimeDadosVencedor(partida,partidaVo);
			listaPartidaVo.add(partidaVo);

		}
		
		return listaPartidaVo;

	}

	private void imprimeDadosVencedor(Partida partida,PartidaVo partidaVo) {

		
		System.out.println("Vencedor: " + partida.getVencedor().getKey() + " | Arma preferida: "
				+ JogadorBO.getArmaPreferida(partida.getVencedor().getValue()));
		
		partidaVo.setVencedor(partida.getVencedor().getKey());
		partidaVo.setArmaPreferida(JogadorBO.getArmaPreferida(partida.getVencedor().getValue()));

		System.out.println(
				"Maior kill streak: " + partida.getMaiorKillStreak().getValue().getDadosPartida().getMaiorKillStreak()
						+ " | Feito por: " + partida.getMaiorKillStreak().getValue().getNomeJogador());
		partidaVo.setMaiorKillStreak(partida.getMaiorKillStreak().getValue().getDadosPartida().getMaiorKillStreak().toString());
		partidaVo.setMaiorKillStreakJogador(partida.getMaiorKillStreak().getValue().getNomeJogador());
		
		

		System.out.println("");
		System.out.println("");
	}

	private void imprimeDadosJogadorAtual(Partida partida,PartidaVo partidaVo) {
		Jogador jogadorAtual;
		DadosPartidaVo dadosPartidaVo = null;
		partidaVo.setListDadosPartidaVo( new ArrayList<DadosPartidaVo>());
		for (Entry<String, Jogador> itemLista : partida.getListaJogadores().getLista().entrySet()) {
			jogadorAtual = itemLista.getValue();
			dadosPartidaVo = new DadosPartidaVo();
			
			System.out.println("- Jogador: " + itemLista.getKey());
			dadosPartidaVo.setJogador(itemLista.getKey());
			System.out.println("- Assassinatos: " + jogadorAtual.getDadosPartida().getAssassinatos());
			dadosPartidaVo.setAssassinatos(jogadorAtual.getDadosPartida().getAssassinatos().toString());
			System.out.println("- Mortes: " + jogadorAtual.getDadosPartida().getMortes());
			dadosPartidaVo.setMortes( jogadorAtual.getDadosPartida().getMortes().toString());
			System.out.println("- Awards: " + jogadorAtual.getDadosPartida().getAwards());
			dadosPartidaVo.setAwards(jogadorAtual.getDadosPartida().getAwards().toString());
			System.out.println("");
			partidaVo.getListDadosPartidaVo().add(dadosPartidaVo);
		}
	}

	
	public List<PartidaVo> lerLog(String logName) {
		List<Partida> partidas = new ArrayList<Partida>();
		try {
			FileInputStream fstream = new FileInputStream(logName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date dataAtual;

			Partida partidaAtual = null;

			String[] parts;

			while ((strLine = br.readLine()) != null) {
				if (strLine.contains(" - ")) {
					parts = strLine.split(" - ");
					dataAtual = formatoData.parse(parts[0]);
					parts = parts[1].split(" ");

					if (parts.length > 4) {
						if (parts[4].equals("started")) {
							partidaAtual = new Partida(parts[2], dataAtual);
						} else {
							if (!parts[0].equals("<WORLD>")) {
								partidaAtual.addAssassinatoJogador(parts[0], parts[4]);
							}

							partidaAtual.addMorteJogador(parts[2]);
						}
					} else {
						partidaAtual.atribuiAwards();
						partidas.add(partidaAtual);
					}

				}
			}

			br.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		

		return imprimirDadosPartida(partidas);
	}

}
