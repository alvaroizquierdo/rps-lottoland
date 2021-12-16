package com.lottoland.rps.core.impl;

import com.lottoland.rps.core.IChoiceStrategy;
import com.lottoland.rps.model.Choice;
import org.springframework.stereotype.Component;



@Component(value = "rockChoice")
public class RockChoice implements IChoiceStrategy {

	@Override
	public Choice selectChoice() {
		return Choice.ROCK;
	}

}
