package com.lottoland.rps.service.impl;

import com.lottoland.rps.dao.IGameRepository;
import com.lottoland.rps.exception.GameNotFoundException;
import com.lottoland.rps.model.Choice;
import com.lottoland.rps.model.Game;
import com.lottoland.rps.model.Result;
import com.lottoland.rps.model.Round;
import com.lottoland.rps.model.Summary;
import com.lottoland.rps.service.IGameService;
import com.lottoland.rps.service.IRoundService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class GameService implements IGameService {

	private IRoundService roundService;
	private IGameRepository gameRepository;

	public GameService(IRoundService roundService, IGameRepository gameRepository) {
		super();
		this.roundService = roundService;
		this.gameRepository = gameRepository;
	}

	@Override
	public Game create(Game game) {
		gameRepository.save(game);
		return game;
	}

	@Override
	public Game find(Long gameId) throws GameNotFoundException {
		return gameRepository.findById(gameId)
				.orElseThrow(() -> new GameNotFoundException(String.format("Game with id=%s not found", gameId)));
	}

	@Override
	public void play(Game game, Choice playerOneChoice, Choice playerTwoChoice) {
		Round round = roundService.create(game, playerOneChoice, playerTwoChoice);
		game.addRound(round);
	}

	@Override
	public Summary gameSummary() {
		List<Round> list = roundService.findAll();

		Map<Result, Long> counted = list.stream()
				.collect(Collectors.groupingBy(round -> round.getPlayerOneResult(), Collectors.counting()));

		// init values - 0
		Stream.of(Result.values()).filter(x -> !counted.containsKey(x)).forEach(x -> counted.put(x, 0L));

		return new Summary(counted.get(Result.WIN), counted.get(Result.LOSE), counted.get(Result.DRAW));
	}

}
