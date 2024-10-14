
package com.printdrawingsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.printdrawingsearch.model.PrintDrawing;

/**
 * This repository interface defines data access operations for PrintDrawing
 * entities. It extends JpaRepository, which provides standard CRUD operations,
 * and adds a custom query to find print drawings within a specified diameter
 * range.
 */
@Repository // Mark this interface as a Spring Data repository
public interface PrintDrawingRespository extends JpaRepository<PrintDrawing, Integer> {

	@Query("SELECT p FROM PrintDrawing p WHERE p.diameterLow BETWEEN :diameterMinValue AND :diameterMaxValue " +
			"AND p.faceLengthLow BETWEEN :faceLengthMinValue AND :faceLengthMaxValue")
	Page<PrintDrawing> findByDiameterAndFaceLengthBetween(
			@Param("diameterMinValue") float diameterMinValue,
			@Param("diameterMaxValue") float diameterMaxValue,
			@Param("faceLengthMinValue") float faceLengthMinValue,
			@Param("faceLengthMaxValue") float faceLengthMaxValue,
			PageRequest pageRequest);
}
