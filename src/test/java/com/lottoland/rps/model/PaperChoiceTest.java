
package com.lottoland.rps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PaperChoiceTest {

	private Choice choice = Choice.PAPER;

	@Test
	public void winsWithRockTest() {
		Assertions.assertTrue(choice.winsWith(Choice.ROCK), "Paper should win with Rock");
	}

	@Test
	public void loseWithScissorsTest() {
		Assertions.assertFalse(choice.winsWith(Choice.SCISSORS), "Paper should lose with Scissors");
	}

	@Test
	public void drawWithPaperTest() {
		Assertions.assertFalse(choice.winsWith(Choice.PAPER), "Paper should draw with Paper");
	}

	@Test
	public void resultWithPaperTest() {
		Assertions.assertEquals(Result.DRAW, choice.resultWith(Choice.PAPER), "Paper should draw with Paper");
	}

	@Test
	public void resultWithRockTest() {
		Assertions.assertEquals(Result.WIN, choice.resultWith(Choice.ROCK), "Paper should win with Rock");
	}

	@Test
	public void resultWithScissorsTest() {
		Assertions.assertEquals(Result.LOSE, choice.resultWith(Choice.SCISSORS), "Paper should lose with Scissors");
	}

	@Test
	public void resultWithExceptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> choice.resultWith(null),
				"IllegalArgumentException expected");
	}

}
