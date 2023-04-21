package com.lazaro.dspesquisa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lazaro.dspesquisa.dto.GameDTO;
import com.lazaro.dspesquisa.entities.Game;
import com.lazaro.dspesquisa.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game> list = gameRepository.findAll();
		
		/*
		 * GameDTO gameDto = new GameDTO(); List<GameDTO> listDTO = new ArrayList<>();
		 * for (Game game : list) { gameDto.setId(game.getId());
		 * gameDto.setTitle(game.getTitle()); gameDto.setPlatform(game.getPlatform());
		 * gameDto.setGenre(game.getGenre()); listDTO.add(gameDto); }
		 * 
		 * return listDTO;
		 */
		
		return list.stream().map(x-> new GameDTO(x)).collect(Collectors.toList());
	}

}
