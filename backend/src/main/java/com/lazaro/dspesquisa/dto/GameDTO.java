package com.lazaro.dspesquisa.dto;

import java.util.ArrayList;
import java.util.List;

import com.lazaro.dspesquisa.entities.Game;
import com.lazaro.dspesquisa.entities.Genre;
import com.lazaro.dspesquisa.entities.Record;
import com.lazaro.dspesquisa.enun.Platform;

public class GameDTO {

	private Long id;
	private String title;
	private Platform platform;
	//private Genre genre;

	//List<Record> records = new ArrayList<>();

	public GameDTO() {
	}

	public GameDTO(Game entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.platform = entity.getPlatform();
		//this.genre = entity.getGenre();

		//this.records = entity.getRecords();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	/*
	 * public Genre getGenre() { return genre; }
	 * 
	 * public void setGenre(Genre genre) { this.genre = genre; }
	 * 
	 * public List<Record> getRecords() { return records; }
	 */
}
