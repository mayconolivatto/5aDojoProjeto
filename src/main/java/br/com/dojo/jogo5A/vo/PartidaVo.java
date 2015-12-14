package br.com.dojo.jogo5A.vo;

import java.io.Serializable;
import java.util.List;

public class PartidaVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8094183499945940934L;
	
	private String partida;
	private List<DadosPartidaVo> listDadosPartidaVo;
	private String vencedor;
	private String armaPreferida;
	private String maiorKillStreak;
	private String maiorKillStreakJogador;
	
	
	
	
	
	
	public String getVencedor() {
		return vencedor;
	}
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}
	public String getArmaPreferida() {
		return armaPreferida;
	}
	public void setArmaPreferida(String armaPreferida) {
		this.armaPreferida = armaPreferida;
	}
	public String getMaiorKillStreak() {
		return maiorKillStreak;
	}
	public void setMaiorKillStreak(String maiorKillStreak) {
		this.maiorKillStreak = maiorKillStreak;
	}
	public String getMaiorKillStreakJogador() {
		return maiorKillStreakJogador;
	}
	public void setMaiorKillStreakJogador(String maiorKillStreakJogador) {
		this.maiorKillStreakJogador = maiorKillStreakJogador;
	}
	public String getPartida() {
		return partida;
	}
	public void setPartida(String partida) {
		this.partida = partida;
	}
	
	
	public List<DadosPartidaVo> getListDadosPartidaVo() {
		return listDadosPartidaVo;
	}
	public void setListDadosPartidaVo(List<DadosPartidaVo> listDadosPartidaVo) {
		this.listDadosPartidaVo = listDadosPartidaVo;
	}
	
	

	
	
}
