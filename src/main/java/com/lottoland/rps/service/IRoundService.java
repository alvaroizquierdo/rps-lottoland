package com.lottoland.rps.service;


import com.lottoland.rps.model.Choice;
import com.lottoland.rps.model.Game;
import com.lottoland.rps.model.Round;

import java.util.List;

public interface IRoundService {

	Round create(Game game, Choice playerOneChoice, Choice playerTwoChoice);

	List<Round> findAll();

}
