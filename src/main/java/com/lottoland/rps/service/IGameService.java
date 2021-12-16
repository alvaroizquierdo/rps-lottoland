package com.lottoland.rps.service;


import com.lottoland.rps.exception.GameNotFoundException;
import com.lottoland.rps.model.Choice;
import com.lottoland.rps.model.Game;
import com.lottoland.rps.model.Summary;

public interface IGameService {

	Game create(Game game);

	Game find(Long gameId) throws GameNotFoundException;

	void play(Game game, Choice playerOneChoice, Choice playerTwoChoice);

	Summary gameSummary();

}
