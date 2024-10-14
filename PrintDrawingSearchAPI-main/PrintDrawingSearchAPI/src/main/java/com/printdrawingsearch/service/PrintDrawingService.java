package com.printdrawingsearch.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.printdrawingsearch.dto.PrintDrawingDto;
import com.printdrawingsearch.dto.PrintDrawingResponse;

/**
 * PrintDrawingService is another layer of abstraction from the repository. It
 * defines methods for interacting with print drawings.
 */
public interface PrintDrawingService {

	/**
	 * Creates a new print drawing.
	 *
	 * @param printDto the print drawing DTO
	 * @return the created print drawing DTO
	 */
	public PrintDrawingDto createPrint(PrintDrawingDto printDto);

	/**
	 * Retrieves all prints drawings with pagination.
	 *
	 * @param pageNo   the page number
	 * @param pageSize the page size
	 * @return the response containing the list of print drawing DTOs
	 */
	public PrintDrawingResponse getAllPrints(int pageNo, int pageSize);

	/**
	 * Retrieves a print drawing by its ID.
	 *
	 * @param id the ID of the print drawing
	 * @return the print drawing DTO
	 */
	public PrintDrawingDto getPrintById(int id);

	/**
	 * Updates a print drawing.
	 *
	 * @param printDrawingUpdate the updated print drawing DTO
	 * @param id                 the ID of the print drawing to update
	 * @return the updated print drawing DTO
	 */
	public PrintDrawingDto updatePrint(PrintDrawingDto printDrawingUpdate, int id);

	/**
	 * Deletes a print drawing by its ID.
	 *
	 * @param id the ID of the print drawing to delete
	 */
	public void deleteByPrintId(int id);

	/**
	 * Retrieves all products.
	 *
	 * @return the list of product DTOs
	 */
	public List<PrintDrawingDto> findAllProducts();

	/**
	 * Retrieves all products with sorting.
	 *
	 * @param field the field to sort by
	 * @return the list of product DTOs
	 */
	public List<PrintDrawingDto> findAllProductsWithSorting(String field);

	/**
	 * Retrieves products with pagination and sorting.
	 *
	 * @param offset   the offset for pagination
	 * @param pageSize the page size
	 * @param field    the field to sort by
	 * @return the page of product DTOs
	 */
	public Page<PrintDrawingDto> findProductsWithPaginationAndSorting(int offset, int pageSize,
			String field);

	/**
	 * Queries the print drawings by combining the diameter filter + face length
	 * filter, pagination, and sorting.
	 *
	 * @param pageNo             the page number
	 * @param pageSize           the page size
	 * @param field              the field to sort by
	 * @param diameterMinValue   min diameter value
	 * @param diameterMaxValue   max diameter value
	 * @param faceLengthMinValue the min face length value
	 * @param faceLengthMaxValue the max face length value
	 * @return the response containing the list of print drawing DTOs
	 */
	public PrintDrawingResponse findDiameterWithPaginationAndSorting(int pageNo, int pageSize,
			String field, float diameterMinValue, float diameterMaxValue, float faceLengthMinValue,
			float faceLengthMaxValue);
}
