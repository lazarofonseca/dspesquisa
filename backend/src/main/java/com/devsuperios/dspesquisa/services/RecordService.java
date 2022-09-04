package com.devsuperios.dspesquisa.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	@Transactional(readOnly = true)
	public List<RecordDTO> findAll() {
		List<Record> list = recordRepository.findAll();
		
		return list.stream().map(x -> new RecordDTO(x)).collect(Collectors.toList());
		
		
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		
		return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}

}
