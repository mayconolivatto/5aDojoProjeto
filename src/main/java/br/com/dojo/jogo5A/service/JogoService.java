package br.com.dojo.jogo5A.service;

import java.util.List;

import br.com.dojo.jogo5A.model.Partida;
import br.com.dojo.jogo5A.vo.PartidaVo;

public interface JogoService {


	List<PartidaVo> lerLog(String logName);

}
