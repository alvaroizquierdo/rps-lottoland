package com.lottoland.rps.model;


public class Round {

	private Long id;
	private Choice playerOneChoice;
	private Choice playerTwoChoice;
	private Result playerOneResult;

	private Game game;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Choice getPlayerOneChoice() {
		return playerOneChoice;
	}

	public void setPlayerOneChoice(Choice playerOneChoice) {
		this.playerOneChoice = playerOneChoice;
	}

	public Choice getPlayerTwoChoice() {
		return playerTwoChoice;
	}

	public void setPlayerTwoChoice(Choice playerTwoChoice) {
		this.playerTwoChoice = playerTwoChoice;
	}

	public Result getPlayerOneResult() {
		return playerOneResult;
	}

	public void setPlayerOneResult(Result playerOneResult) {
		this.playerOneResult = playerOneResult;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
