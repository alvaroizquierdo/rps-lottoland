package com.lottoland.rps.service.impl;

import com.lottoland.rps.dao.IRoundRepository;
import com.lottoland.rps.model.Choice;
import com.lottoland.rps.model.Game;
import com.lottoland.rps.model.Round;
import com.lottoland.rps.service.IRoundService;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class RoundService implements IRoundService {

	private IRoundRepository roundRepository;

	public RoundService(IRoundRepository roundRepository) {
		super();
		this.roundRepository = roundRepository;
	}

	@Override
	public Round create(Game game, Choice playerOneChoice, Choice playerTwoChoice) {
		Round round = new Round();
		round.setGame(game);
		round.setPlayerOneChoice(playerOneChoice);
		round.setPlayerTwoChoice(playerTwoChoice);
		round.setPlayerOneResult(playerOneChoice.resultWith(round.getPlayerTwoChoice()));
		roundRepository.save(round);
		return round;
	}

	@Override
	public List<Round> findAll() {
		return roundRepository.findAll();
	}

}
