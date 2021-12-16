package com.lottoland.rps.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private Long id;
	private List<Round> rounds;

	public Game() {
		this.rounds = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public void addRound(Round round) {
		this.rounds.add(round);
	}

}
