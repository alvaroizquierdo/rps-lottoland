package com.lottoland.rps.state;

import com.lottoland.rps.model.Game;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class CurrentGame {

	private Game game;

	public CurrentGame() {
		this.game = new Game();
	}

	public Game getGame() {
		return game;
	}

	public void restart() {
		this.game = new Game();
	}

}
