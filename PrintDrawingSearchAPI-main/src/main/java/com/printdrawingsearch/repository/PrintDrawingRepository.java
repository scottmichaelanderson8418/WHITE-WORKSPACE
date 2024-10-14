
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
 * entities. It extends JpaRepository, which provides standard CRUD operations.
 * 
 * 
 */
@Repository // Mark this interface as a Spring Data repository
public interface PrintDrawingRepository extends JpaRepository<PrintDrawing, Integer> {

	/**
	 * A custom method to search for the user based on the diameter and facelength
	 * parameters. The response paginated to optimize visual representation of the
	 * users and prevent overloading the query response data
	 *
	 * @param diameterMinValue   the diameter min value
	 * @param diameterMaxValue   the diameter max value
	 * @param faceLengthMinValue the face length min value
	 * @param faceLengthMaxValue the face length max value
	 * @param pageRequest        the page request
	 * @return list of all the users matching the search query
	 */
	@Query("SELECT p FROM PrintDrawing p WHERE p.diameterLow BETWEEN :diameterMinValue AND :diameterMaxValue " +
			"AND p.faceLengthLow BETWEEN :faceLengthMinValue AND :faceLengthMaxValue")
	Page<PrintDrawing> findByDiameterAndFaceLengthBetween(
			@Param("diameterMinValue") float diameterMinValue,
			@Param("diameterMaxValue") float diameterMaxValue,
			@Param("faceLengthMinValue") float faceLengthMinValue,
			@Param("faceLengthMaxValue") float faceLengthMaxValue, PageRequest pageRequest);

	/**
	 * Save String value
	 *
	 * @param string the string
	 */
	void save(String string);
}
