package com.lottoland.rps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RockChoiceTest {

	private Choice choice = Choice.ROCK;

	@Test
	public void winsWithScissorsTest() {
		Assertions.assertTrue(choice.winsWith(Choice.SCISSORS), "Rock should win with Scissors");
	}

	@Test
	public void loseWithPaperTest() {
		Assertions.assertFalse(choice.winsWith(Choice.PAPER), "Rock should lose with Paper");
	}

	@Test
	public void drawWithRockTest() {
		Assertions.assertFalse(choice.winsWith(Choice.ROCK), "Rock should draw with Rock");
	}

	@Test
	public void resultWithPaperTest() {
		Assertions.assertEquals(Result.LOSE, choice.resultWith(Choice.PAPER), "Rock should lose with Paper");
	}

	@Test
	public void resultWithRockTest() {
		Assertions.assertEquals(Result.DRAW, choice.resultWith(Choice.ROCK), "Rock should draw with Rock");
	}

	@Test
	public void resultWithScissorsTest() {
		Assertions.assertEquals(Result.WIN, choice.resultWith(Choice.SCISSORS), "Rock should win with Scissors");
	}

	@Test
	public void resultWithExceptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> choice.resultWith(null),
				"IllegalArgumentException expected");
	}

}
