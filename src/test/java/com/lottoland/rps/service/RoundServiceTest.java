package com.lottoland.rps.service;

import com.lottoland.rps.dao.IRoundRepository;
import com.lottoland.rps.model.Choice;
import com.lottoland.rps.model.Game;
import com.lottoland.rps.model.Result;
import com.lottoland.rps.model.Round;
import com.lottoland.rps.service.impl.RoundService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class RoundServiceTest {

	@Mock
	private IRoundRepository roundRepository;

	private IRoundService roundService;

	@BeforeEach
	public void setup() {
		roundService = new RoundService(roundRepository);
	}

	@Test
	public void createRoundWithPaperDrawResultTest() {
		Round round = roundService.create(new Game(), Choice.PAPER, Choice.PAPER);
		Assertions.assertEquals(Result.DRAW, round.getPlayerOneResult(), "result should be draw");
	}

	@Test
	public void createRoundWithRockDrawResultTest() {
		Round round = roundService.create(new Game(), Choice.ROCK, Choice.ROCK);
		Assertions.assertEquals(Result.DRAW, round.getPlayerOneResult(), "result should be draw");
	}

	@Test
	public void createRoundWithScissorsDrawResultTest() {
		Round round = roundService.create(new Game(), Choice.SCISSORS, Choice.SCISSORS);
		Assertions.assertEquals(Result.DRAW, round.getPlayerOneResult(), "result should be draw");
	}

	@Test
	public void createRoundWithScissorsWinResultTest() {
		Round round = roundService.create(new Game(), Choice.SCISSORS, Choice.PAPER);
		Assertions.assertEquals(Result.WIN, round.getPlayerOneResult(), "result should be win");
	}

	@Test
	public void createRoundWithScissorsLoseResultTest() {
		Round round = roundService.create(new Game(), Choice.SCISSORS, Choice.ROCK);
		Assertions.assertEquals(Result.LOSE, round.getPlayerOneResult(), "result should be lose");
	}

	@Test
	public void createRoundWithPaperWinResultTest() {
		Round round = roundService.create(new Game(), Choice.PAPER, Choice.ROCK);
		Assertions.assertEquals(Result.WIN, round.getPlayerOneResult(), "result should be win");
	}

	@Test
	public void createRoundWithPaperLoseResultTest() {
		Round round = roundService.create(new Game(), Choice.PAPER, Choice.SCISSORS);
		Assertions.assertEquals(Result.LOSE, round.getPlayerOneResult(), "result should be lose");
	}

	@Test
	public void createRoundWithRockWinResultTest() {
		Round round = roundService.create(new Game(), Choice.ROCK, Choice.SCISSORS);
		Assertions.assertEquals(Result.WIN, round.getPlayerOneResult(), "result should be win");
	}

	@Test
	public void createRoundWithRockLoseResultTest() {
		Round round = roundService.create(new Game(), Choice.ROCK, Choice.PAPER);
		Assertions.assertEquals(Result.LOSE, round.getPlayerOneResult(), "result should be lose");
	}

}
