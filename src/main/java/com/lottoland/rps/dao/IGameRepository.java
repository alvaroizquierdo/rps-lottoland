package com.lottoland.rps.dao;

import com.lottoland.rps.model.Game;

import java.util.Optional;

public interface IGameRepository {

	Game save(Game game);

	Optional<Game> findById(Long id);

}
