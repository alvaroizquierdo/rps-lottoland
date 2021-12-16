package com.lottoland.rps.model;


public class Summary {

	private final Long totalRounds;
	private final Long totalPlayerOneWins;
	private final Long totalPlayerTwoWins;
	private final Long totalDraws;

	public Summary(Long totalPlayerOneWins, Long totalPlayerTwoWins, Long totalDraws) {
		super();
		this.totalPlayerOneWins = totalPlayerOneWins;
		this.totalPlayerTwoWins = totalPlayerTwoWins;
		this.totalDraws = totalDraws;
		this.totalRounds = totalPlayerOneWins + totalPlayerTwoWins + totalDraws;
	}

	public Long getTotalRounds() {
		return totalRounds;
	}

	public Long getTotalPlayerOneWins() {
		return totalPlayerOneWins;
	}

	public Long getTotalPlayerTwoWins() {
		return totalPlayerTwoWins;
	}

	public Long getTotalDraws() {
		return totalDraws;
	}

}
