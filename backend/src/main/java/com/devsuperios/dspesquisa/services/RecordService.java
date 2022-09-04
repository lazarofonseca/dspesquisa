package com.devsuperios.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperios.dspesquisa.dto.RecordDTO;
import com.devsuperios.dspesquisa.dto.RecordInsertDTO;
import com.devsuperios.dspesquisa.entities.Game;
import com.devsuperios.dspesquisa.entities.Record;
import com.devsuperios.dspesquisa.repositories.GameRepository;
import com.devsuperios.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository recordRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record record = new Record();
		record.setName(dto.getName());
		record.setAge(dto.getAge());
		record.setMoment(Instant.now());

		Game game = gameRepository.getOne(dto.getGameID());

		record.setGame(game);

		record = recordRepository.save(record);

		return new RecordDTO(record);

	}

}
