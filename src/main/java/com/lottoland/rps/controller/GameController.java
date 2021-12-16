package com.lottoland.rps.controller;

import com.lottoland.rps.core.IChoiceStrategy;
import com.lottoland.rps.service.IGameService;
import com.lottoland.rps.state.CurrentGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/game")
public class GameController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

	private CurrentGame currentGame;
	private IGameService gameService;
	private IChoiceStrategy rockChoice;
	private IChoiceStrategy randomChoice;

	public GameController(IGameService gameService, @Qualifier("rockChoice") IChoiceStrategy rockChoice,
			@Qualifier("randomChoice") IChoiceStrategy randomChoice, CurrentGame currentGame) {
		super();
		this.gameService = gameService;
		this.rockChoice = rockChoice;
		this.randomChoice = randomChoice;
		this.currentGame = currentGame;
	}

	@GetMapping()
	public ModelAndView game() {
		ModelAndView modelAndView = new ModelAndView("game");
		modelAndView.addObject("rounds", currentGame.getGame().getRounds());
		return modelAndView;
	}

	@PostMapping("/play")
	public String play() {
		LOGGER.info("Round played");
		gameService.play(currentGame.getGame(), randomChoice.selectChoice(), rockChoice.selectChoice());
		return "redirect:/game";
	}

	@PostMapping("/restart")
	public String restart() {
		currentGame.restart();
		return "redirect:/game";
	}

}
