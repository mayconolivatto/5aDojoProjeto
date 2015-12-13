package br.com.dojo.jogo5A.teste;

import java.util.HashMap;
import java.util.Map;

import br.com.dojo.jogo5A.bo.JogadorBO;
import br.com.dojo.jogo5A.model.Jogador;
import br.com.dojo.jogo5A.repository.RepositorioJogador;
import junit.framework.TestCase;

public class ReoisitorioJogadorTeste extends TestCase{
	private RepositorioJogador listaJogadores;

	public void testCriaLista() {
		listaJogadores = new RepositorioJogador();

		assertNotNull(listaJogadores);
	}

	public void testAddJogador() {
		listaJogadores = new RepositorioJogador();

		listaJogadores.addJogador(new Jogador("Pedro"));
		listaJogadores.addJogador(new Jogador("Joao"));
		listaJogadores.addJogador(new Jogador("Claudia"));

		Map<String, Jogador> mapTeste = new HashMap<String, Jogador>();

		mapTeste.put("Pedro", listaJogadores.getLista().get("Pedro"));
		mapTeste.put("Joao", listaJogadores.getLista().get("Joao"));
		mapTeste.put("Claudia", listaJogadores.getLista().get("Claudia"));

		assertEquals(mapTeste, listaJogadores.getLista());
	}

	public void testAddAssassinato() {
		listaJogadores = new RepositorioJogador();

		listaJogadores.addJogador(new Jogador("Claudia"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));

		assertEquals(new Integer(1), listaJogadores.getLista().get("Claudia").getDadosPartida().getAssassinatos());

		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));

		assertEquals(new Integer(5), listaJogadores.getLista().get("Claudia").getDadosPartida().getAssassinatos());
	}

	public void testAddMorte() {
		listaJogadores = new RepositorioJogador();
		listaJogadores.addJogador(new Jogador("Claudia"));

		JogadorBO.addAward(listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAward(listaJogadores.getLista().get("Claudia"));

		assertEquals(new Integer(0), listaJogadores.getLista().get("Claudia").getDadosPartida().getMortes());

		JogadorBO.addAward(listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAward(listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAward(listaJogadores.getLista().get("Claudia"));

		assertEquals(new Integer(0), listaJogadores.getLista().get("Claudia").getDadosPartida().getMortes());
	}

	public void testAtribuiAwards() {
		listaJogadores = new RepositorioJogador();

		listaJogadores.addJogador(new Jogador("Claudia"));
		JogadorBO.addAssassinato("M16", listaJogadores.getLista().get("Claudia"));
		JogadorBO.atribuiAwards(listaJogadores);

		assertEquals(new Integer(1), listaJogadores.getLista().get("Claudia").getDadosPartida().getAwards());
	}

	public void testGetVencedor() {
		listaJogadores = new RepositorioJogador();

		listaJogadores.addJogador(new Jogador("Claudia"));
		listaJogadores.addJogador(new Jogador("Pedro"));
		listaJogadores.addJogador(new Jogador("Rafael"));
		listaJogadores.addJogador(new Jogador("Joao"));

		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Rafael"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Pedro"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Joao"));
		JogadorBO.addAssassinato("M16", listaJogadores.getLista().get("Claudia"));

		assertEquals("Claudia", listaJogadores.getVencedor().getKey());
	}

	public void testGetMaiorKillStreak() {
		listaJogadores = new RepositorioJogador();

		listaJogadores.addJogador(new Jogador("Claudia"));
		listaJogadores.addJogador(new Jogador("Pedro"));
		listaJogadores.addJogador(new Jogador("Rafael"));
		listaJogadores.addJogador(new Jogador("Joao"));

		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAssassinato("M16", listaJogadores.getLista().get("Claudia"));
		JogadorBO.addAssassinato("M16", listaJogadores.getLista().get("Claudia"));

		JogadorBO.addMorte(listaJogadores.getLista().get("Claudia"));

		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Rafael"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Pedro"));
		JogadorBO.addAssassinato("AK47", listaJogadores.getLista().get("Joao"));
		JogadorBO.addAssassinato("M16", listaJogadores.getLista().get("Claudia"));

		assertEquals("Claudia", listaJogadores.getMaiorKillStreak().getKey());
		assertEquals(new Integer(3),
				listaJogadores.getMaiorKillStreak().getValue().getDadosPartida().getMaiorKillStreak());
	}
}
