package br.com.dojo.jogo5A.teste;

import br.com.dojo.jogo5A.bo.JogadorBO;
import br.com.dojo.jogo5A.model.Jogador;
import junit.framework.TestCase;

public class JogadorTest extends TestCase {
	Jogador jogadorTeste;

	public void testCriaJogador() {
		jogadorTeste = new Jogador("Jogador Teste Maycon");

		assertNotNull(jogadorTeste);
		assertEquals("Jogador Teste Maycon", jogadorTeste.getNomeJogador());
	}

	public void testAddAssassinato() {
		jogadorTeste = new Jogador("Jogador Teste Maycon");

		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);

		assertEquals(new Integer(5), jogadorTeste.getDadosPartida().getAssassinatos());
	}

	public void testArmaPreferida() {
		jogadorTeste = new Jogador("Jogador Teste Maycon");
		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		assertEquals("M16", JogadorBO.getArmaPreferida(jogadorTeste));

		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);

		assertEquals("AK47", JogadorBO.getArmaPreferida(jogadorTeste));

	}

	public void testAddMorte() {
		jogadorTeste = new Jogador("Jogador Teste");

		JogadorBO.addMorte(jogadorTeste);

		assertEquals(new Integer(1), jogadorTeste.getDadosPartida().getMortes());

		JogadorBO.addMorte(jogadorTeste);
		JogadorBO.addMorte(jogadorTeste);
		JogadorBO.addMorte(jogadorTeste);

		assertEquals(new Integer(4), jogadorTeste.getDadosPartida().getMortes());
	}

	public void testAddAwards() {
		jogadorTeste = new Jogador("Jogador Teste");

		JogadorBO.addAward(jogadorTeste);

		assertEquals(new Integer(1), jogadorTeste.getDadosPartida().getAwards());

	}

	public void testKillStreakAtual() {
		jogadorTeste = new Jogador("Jogador Teste");

		JogadorBO.addAssassinato("M16", jogadorTeste);

		assertEquals(new Integer(1), jogadorTeste.getDadosPartida().getKillStreakAtual());

		JogadorBO.addMorte(jogadorTeste);

		assertEquals(new Integer(0), jogadorTeste.getDadosPartida().getKillStreakAtual());
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);

		assertEquals(new Integer(4), jogadorTeste.getDadosPartida().getKillStreakAtual());

		JogadorBO.addMorte(jogadorTeste);
		assertEquals(new Integer(0), jogadorTeste.getDadosPartida().getKillStreakAtual());

	}

	public void testMaiorKillStreak() {
		jogadorTeste = new Jogador("Jogador Teste");
		JogadorBO.addAssassinato("M16", jogadorTeste);
		
		JogadorBO.addMorte(jogadorTeste);

		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("M16", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);
		
		JogadorBO.addMorte(jogadorTeste);

		JogadorBO.addAssassinato("AK47", jogadorTeste);
		JogadorBO.addAssassinato("AK47", jogadorTeste);

//		assertEquals(new Integer(2), jogadorTeste.getDadosPartida().getKillStreakAtual());
//		assertEquals(new Integer(4), jogadorTeste.getDadosPartida().getMaiorKillStreak());

	}
}