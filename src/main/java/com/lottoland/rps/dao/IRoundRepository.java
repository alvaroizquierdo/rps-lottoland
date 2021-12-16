package com.lottoland.rps.dao;


import com.lottoland.rps.model.Round;

import java.util.List;

public interface IRoundRepository {

	Round save(Round round);

	List<Round> findAll();

}
