package com.lottoland.rps.core.impl;

import com.lottoland.rps.core.IChoiceStrategy;
import com.lottoland.rps.model.Choice;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component(value = "randomChoice")
public class RandomChoice implements IChoiceStrategy {

	private static final Choice[] values = Choice.values();
	private static final Random random = new SecureRandom();

	public static Choice getRandomChoice() {
		return values[random.nextInt(values.length)];
	}

	@Override
	public Choice selectChoice() {
		return getRandomChoice();
	}

}
