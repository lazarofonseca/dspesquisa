package com.devsuperios.dspesquisa.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperios.dspesquisa.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long>{

	@Query("SELECT obj FROM Record obj WHERE "
			+ "(:minDate IS NULL OR obj.moment >= :minDate) "
			+ "AND "
			+ "(:maxDate IS NULL OR obj.moment <= :maxDate)")
	Page<Record> findByMoments(Instant minDate, Instant maxDate, Pageable pageable);

}
