package com.lottoland.rps.dao.impl;

import com.lottoland.rps.dao.IRoundRepository;
import com.lottoland.rps.model.Round;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class RoundRepository implements IRoundRepository {

	private final AtomicLong counter = new AtomicLong();
	private final Map<Long, Round> result = new ConcurrentHashMap<>();

	@Override
	public Round save(Round round) {
		round.setId(counter.incrementAndGet());
		result.put(round.getId(), round);
		return round;
	}

	@Override
	public List<Round> findAll() {
		return result.values().stream().collect(Collectors.toList());
	}

}
