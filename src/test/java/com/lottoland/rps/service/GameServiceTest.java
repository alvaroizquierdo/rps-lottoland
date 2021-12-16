package com.lottoland.rps.service;

import com.lottoland.rps.dao.IGameRepository;
import com.lottoland.rps.model.Choice;
import com.lottoland.rps.model.Game;
import com.lottoland.rps.service.impl.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

	@Mock
	private IRoundService roundService;
	@Mock
	private IGameRepository gameRepository;

	private IGameService gameService;

	@BeforeEach
	public void setup() {
		gameService = new GameService(roundService, gameRepository);
	}

	@Test
	public void testNoRounds() {

		Game game = new Game();

		Assertions.assertTrue(game.getRounds().isEmpty(), "should be no rounds");

	}

	@Test
	public void testOneRound() {

		Game game = new Game();

		gameService.play(game, Choice.PAPER, Choice.PAPER);

		Assertions.assertEquals(1, game.getRounds().size(), "should be one round");

	}

	@Test
	public void testTwoRounds() {

		Game game = new Game();

		gameService.play(game, Choice.PAPER, Choice.PAPER);
		gameService.play(game, Choice.ROCK, Choice.SCISSORS);

		Assertions.assertEquals(2, game.getRounds().size(), "should be two rounds");

	}

}
