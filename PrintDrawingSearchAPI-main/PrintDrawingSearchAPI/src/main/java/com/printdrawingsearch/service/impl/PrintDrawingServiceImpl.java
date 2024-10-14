package com.printdrawingsearch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.printdrawingsearch.dto.PrintDrawingDto;
import com.printdrawingsearch.dto.PrintDrawingResponse;
import com.printdrawingsearch.exceptions.PrintDrawingNotFoundException;
import com.printdrawingsearch.model.PrintDrawing;
import com.printdrawingsearch.repository.PrintDrawingRepository;
import com.printdrawingsearch.service.PrintDrawingService;

/**
 * Class the implements all the methods in the PrintDrawingService interface. The PrintDrawingService interface provides
 * a layer of abstraction between the controller methods and their implementation
 */

@Service
public class PrintDrawingServiceImpl implements PrintDrawingService {

	Logger logger = LoggerFactory.getLogger(PrintDrawingServiceImpl.class.getName());

	private PrintDrawingRepository printDrawingRepository;

	/**
	 * Overloaded constructor that creates an object of the PrintDrawingServiceImpl
	 *
	 * 
	 * @param printRepository Repository or database containing the attributes for the print drawings
	 */
	public PrintDrawingServiceImpl(PrintDrawingRepository printRepository) {
		this.printDrawingRepository = printRepository;
	}

	/**
	 * Helper method to map PrintDrawing to PrintDrawingDto.
	 *
	 * @param printDrawing The PrintDrawing to be converted.
	 * @return The converted PrintDrawingDto.
	 */
	private PrintDrawingDto convertToDto(PrintDrawing printDrawing) {

		logger.trace("Entered......convertToDto() ");

		PrintDrawingDto dto = new PrintDrawingDto();
		// ... map properties from printDrawing to dto

		logger.trace("Exited......convertToDto() ");
		return dto;
	}

	/**
	 * Creates a new print drawing entry in the database.
	 *
	 * @param printDrawingDto Data transfer object containing details of the print drawing to create.
	 * @return A data transfer object representing the created print drawing.
	 */
	@Override
	public PrintDrawingDto createPrint(PrintDrawingDto printDrawingDto) {

		logger.trace("Entered......createPrint() ");

		PrintDrawing printDrawing = new PrintDrawing();

		printDrawing.setBearingMax(printDrawingDto.getBearingMax());
		printDrawing.setBearingMin(printDrawingDto.getBearingMin());
		printDrawing.setCustomer(printDrawingDto.getCustomer());
		printDrawing.setCustomerPin(printDrawingDto.getCustomerPin());
		printDrawing.setCustomerRevision(printDrawingDto.getCustomerRevision());
		printDrawing.setDate(printDrawingDto.getDate());
		printDrawing.setDateCreated(printDrawingDto.getDateCreated());
		printDrawing.setDiameterLow(printDrawingDto.getDiameter());
		printDrawing.setDmgDrawingPath(printDrawingDto.getDmgDrawingPath());
		printDrawing.setDrawingName(printDrawingDto.getDrawingName());
		printDrawing.setFaceLengthLow(printDrawingDto.getFaceLength());
		printDrawing.setOem(printDrawingDto.getOem());
		printDrawing.setOriginatingCustomer(printDrawingDto.getOriginatingCustomer());
		printDrawing.setPartNo(printDrawingDto.getPartNo());
		printDrawing.setPdfPath(printDrawingDto.getPdfPath());
		printDrawing.setPrevPartNo(printDrawingDto.getPrevPartNo());
		printDrawing.setProductCode(printDrawingDto.getProductCode());
		printDrawing.setRevNumber(printDrawingDto.getRevNumber());
		printDrawing.setScannedPath(printDrawingDto.getScannedPath());
		printDrawing.setSteps(printDrawingDto.getSteps());
		printDrawing.setSubcontractor(printDrawingDto.getSubcontractor());
		printDrawing.setType(printDrawingDto.getType());
		printDrawing.setXlsmPath(printDrawingDto.getXlsmPath());
		printDrawing.setXlsxPath(printDrawingDto.getXlsxPath());

		PrintDrawing newPrint = printDrawingRepository.save(printDrawing);
		logger.trace("Exited......createPrint() ");
		return mapToDto(newPrint);
	}

	/**
	 * Updates an existing print drawing with new details.
	 *
	 * @param printDrawing       The existing print drawing to update.
	 * @param printDrawingUpdate Data transfer object containing updated details of the print drawing.
	 * @return The updated print drawing.
	 */
	public PrintDrawing createPrintUpdate(PrintDrawing printDrawing, PrintDrawingDto printDrawingUpdate) {

		logger.trace("Entered......createPrintUpdate() ");

		printDrawing.setBearingMax(printDrawingUpdate.getBearingMax());
		printDrawing.setBearingMin(printDrawingUpdate.getBearingMin());
		printDrawing.setCustomer(printDrawingUpdate.getCustomer());
		printDrawing.setCustomerPin(printDrawingUpdate.getCustomerPin());
		printDrawing.setCustomerRevision(printDrawingUpdate.getCustomerRevision());
		printDrawing.setDate(printDrawingUpdate.getDate());
		printDrawing.setDateCreated(printDrawingUpdate.getDateCreated());
		printDrawing.setDiameterLow(printDrawingUpdate.getDiameter());
		printDrawing.setDmgDrawingPath(printDrawingUpdate.getDmgDrawingPath());
		printDrawing.setDrawingName(printDrawingUpdate.getDrawingName());
		printDrawing.setFaceLengthLow(printDrawingUpdate.getFaceLength());
		printDrawing.setOem(printDrawingUpdate.getOem());
		printDrawing.setOriginatingCustomer(printDrawingUpdate.getOriginatingCustomer());
		printDrawing.setPartNo(printDrawingUpdate.getPartNo());
		printDrawing.setPdfPath(printDrawingUpdate.getPdfPath());
		printDrawing.setPrevPartNo(printDrawingUpdate.getPrevPartNo());
		printDrawing.setProductCode(printDrawingUpdate.getProductCode());
		printDrawing.setRevNumber(printDrawingUpdate.getRevNumber());
		printDrawing.setScannedPath(printDrawingUpdate.getScannedPath());
		printDrawing.setSteps(printDrawingUpdate.getSteps());
		printDrawing.setSubcontractor(printDrawingUpdate.getSubcontractor());
		printDrawing.setType(printDrawingUpdate.getType());
		printDrawing.setXlsmPath(printDrawingUpdate.getXlsmPath());
		printDrawing.setXlsxPath(printDrawingUpdate.getXlsxPath());
		logger.trace("Exited......createPrintUpdate() ");
		return printDrawing;
	}

	/**
	 * Deletes a print drawing entry by its ID.
	 *
	 * @param id The ID of the print drawing to delete.
	 * @throws PrintDrawingNotFoundException if the print drawing with the given ID is not found.
	 */
	@Override
	public void deleteByPrintId(int id) {
		logger.trace("Entered......deleteByPrintId() ");

		PrintDrawing printDrawing = printDrawingRepository.findById(id)
				.orElseThrow(() -> new PrintDrawingNotFoundException("Print drawing could not be deleted"));

		printDrawingRepository.delete(printDrawing);
		logger.trace("Exited......deleteByPrintId() ");
	}

	/**
	 * Retrieves all print drawing entries.
	 *
	 * @return A list of data transfer objects representing all print drawings.
	 */
	public List<PrintDrawingDto> findAllProducts() {
		List<PrintDrawing> printDrawingList = printDrawingRepository.findAll();
		return printDrawingList.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	/**
	 * Retrieves all print drawing entries with sorting.
	 *
	 * @param field The field to sort by.
	 * @return A list of sorted data transfer objects representing all print drawings.
	 */
	public List<PrintDrawingDto> findAllProductsWithSorting(String field) {
		List<PrintDrawing> printDrawingList = printDrawingRepository.findAll(Sort.by(Sort.Direction.ASC, field));
		return printDrawingList.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	/**
	 * Finds print drawings within specified diameter and face length range with pagination and sorting.
	 *
	 * @param pageNo             The page number to retrieve.
	 * @param pageSize           The number of items per page.
	 * @param sortField          The field to sort by.
	 * @param diameterMinValue   The minimum value for diameter.
	 * @param diameterMaxValue   The maximum value for diameter.
	 * @param faceLengthMinValue The minimum value for face length.
	 * @param faceLengthMaxValue The maximum value for face length.
	 * @return A PrintDrawingResponse object containing the requested print drawings.
	 */
	public PrintDrawingResponse findDiameterWithPaginationAndSorting(int pageNo, int pageSize, String sortField,
			float diameterMinValue, float diameterMaxValue, float faceLengthMinValue, float faceLengthMaxValue) {
		logger.trace("Entered......findDiameterWithPaginationAndSorting() ");

		// Create PageRequest for Pagination and Sorting
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize).withSort(Sort.by(sortField));

		// Fetch Drawings within Diameter Range and Apply Pagination
		Page<PrintDrawing> drawings = printDrawingRepository.findByDiameterAndFaceLengthBetween(diameterMinValue,
				diameterMaxValue, faceLengthMinValue, faceLengthMaxValue, pageRequest);

		// Extract Content from Page Object and Convert to DTOs
		List<PrintDrawing> printDrawingList = drawings.getContent();

		List<PrintDrawingDto> printListDto = new ArrayList<>();

		for (PrintDrawing printDrawing : printDrawingList) {
			printListDto.add(mapToDto(printDrawing));
		}

		// Create a PrintDrawingResponse object and populate its fields
		PrintDrawingResponse printDrawingResponse = new PrintDrawingResponse();

		// List of DTOs for the current page
		printDrawingResponse.setContent(printListDto);

		// Current page number
		printDrawingResponse.setPageNo(drawings.getNumber());

		// Number of items per page
		printDrawingResponse.setPageSize(drawings.getSize());

		// Total number of elements across all pages
		printDrawingResponse.setTotalElements(drawings.getTotalElements());

		// Total number of pages
		printDrawingResponse.setTotalPages(drawings.getTotalPages());

		// True if this is the last page
		printDrawingResponse.setLast(drawings.isLast());
		logger.trace("Exited......findDiameterWithPaginationAndSorting() ");
		// Return the Response
		return printDrawingResponse;
	}

	/**
	 * Finds all products with pagination and sorting.
	 *
	 * @param offset   The offset of the page to retrieve.
	 * @param pageSize The number of items per page.
	 * @param field    The field to sort by.
	 * @return A Page of PrintDrawingDto objects.
	 */
	@Override
	public Page<PrintDrawingDto> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
		logger.trace("Entered......findProductsWithPaginationAndSorting() ");

		Page<PrintDrawing> drawings = printDrawingRepository
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));

		// Convert Page<PrintDrawing> to List<PrintDrawingDto>
		List<PrintDrawingDto> dtos = drawings.stream().map(this::convertToDto).collect(Collectors.toList());

		// Create a new Page<PrintDrawingDto> with the converted DTOs and
		// original
		// pagination info
		logger.trace("Exited......findProductsWithPaginationAndSorting() ");
		return new PageImpl<>(dtos, drawings.getPageable(), drawings.getTotalElements());
	}

	/**
	 * Retrieves all print drawings with pagination.
	 *
	 * @param pageNo   The page number to retrieve.
	 * @param pageSize The number of items per page.
	 * @return A PrintDrawingResponse containing all print drawings for the specified page.
	 */
	@Override
	public PrintDrawingResponse getAllPrints(int pageNo, int pageSize) {
		logger.trace("Entered......getAllPrints() ");

		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<PrintDrawing> printDrawing = printDrawingRepository.findAll(pageable);

		// this "printDrawing.getContent()" will get everything in the page
		List<PrintDrawing> printDrawingList = printDrawing.getContent();

		List<PrintDrawingDto> content = printDrawingList.stream().map(this::mapToDto).collect(Collectors.toList());

		PrintDrawingResponse printDrawingResponse = new PrintDrawingResponse();

		printDrawingResponse.setContent(content);
		printDrawingResponse.setPageNo(printDrawing.getNumber());
		printDrawingResponse.setPageSize(printDrawing.getSize());
		printDrawingResponse.setTotalElements(printDrawing.getTotalElements());
		printDrawingResponse.setTotalPages(printDrawing.getTotalPages());
		printDrawingResponse.setLast(printDrawing.isLast());
		logger.trace("Exited......getAllPrints() ");
		return printDrawingResponse;
	}

	/**
	 * Retrieves a print drawing entry by its ID.
	 *
	 * @param id The ID of the print drawing to retrieve.
	 * @return A data transfer object representing the retrieved print drawing.
	 * @throws PrintDrawingNotFoundException if the print drawing with the given ID is not found.
	 */
	@Override
	public PrintDrawingDto getPrintById(int id) {
		logger.trace("Entered......getPrintById() ");

		PrintDrawing printDrawing = printDrawingRepository.findById(id)
				.orElseThrow(() -> new PrintDrawingNotFoundException("Print drawing could not be found :("));
		logger.trace("Exited......getPrintById() ");
		return mapToDto(printDrawing);
	}

	/**
	 * Maps a PrintDrawing model to a PrintDrawingDto.
	 *
	 * @param printDrawing The print drawing model to map.
	 * @return The mapped data transfer object.
	 */
	private PrintDrawingDto mapToDto(PrintDrawing printDrawing) {
		PrintDrawingDto printDrawingDto = new PrintDrawingDto();
		printDrawingDto.setId(printDrawing.getId());
		printDrawingDto.setBearingMax(printDrawing.getBearingMax());
		printDrawingDto.setBearingMin(printDrawing.getBearingMin());
		printDrawingDto.setCustomer(printDrawing.getCustomer());
		printDrawingDto.setCustomerPin(printDrawing.getCustomerPin());
		printDrawingDto.setCustomerRevision(printDrawing.getCustomerRevision());
		printDrawingDto.setDate(printDrawing.getDate());
		printDrawingDto.setDateCreated(printDrawing.getDateCreated());
		printDrawingDto.setDiameter(printDrawing.getDiameterLow());

		printDrawingDto.setDmgDrawingPath(printDrawing.getDmgDrawingPath());
		printDrawingDto.setDrawingName(printDrawing.getDrawingName());
		printDrawingDto.setFaceLength(printDrawing.getFaceLengthLow());
		printDrawingDto.setOem(printDrawing.getOem());
		printDrawingDto.setOriginatingCustomer(printDrawing.getOriginatingCustomer());
		printDrawingDto.setPartNo(printDrawing.getPartNo());
		printDrawingDto.setPdfPath(printDrawing.getPdfPath());
		printDrawingDto.setPrevPartNo(printDrawing.getPrevPartNo());
		printDrawingDto.setProductCode(printDrawing.getProductCode());
		printDrawingDto.setRevNumber(printDrawing.getRevNumber());
		printDrawingDto.setScannedPath(printDrawing.getScannedPath());
		printDrawingDto.setSteps(printDrawing.getSteps());
		printDrawingDto.setType(printDrawing.getType());
		printDrawingDto.setSubcontractor(printDrawing.getSubcontractor());
		printDrawingDto.setXlsmPath(printDrawing.getXlsmPath());
		printDrawingDto.setXlsxPath(printDrawing.getXlsxPath());
		return printDrawingDto;
	}

	/**
	 * Updates a PrintDrawing entity with the provided data.
	 *
	 * @param printDrawingUpdate The data to update the PrintDrawing entity with.
	 * @param id                 The ID of the PrintDrawing entity to update.
	 * @return The updated PrintDrawing DTO.
	 * @throws PrintDrawingNotFoundException If the PrintDrawing entity to update is not found.
	 */
	@Override
	public PrintDrawingDto updatePrint(PrintDrawingDto printDrawingUpdate, int id)

			throws PrintDrawingNotFoundException {
		logger.trace("Entered......updatePrint() ");

		try {
			// Find the PrintDrawing entity by ID or throw an exception if not found
			PrintDrawing printDrawing = printDrawingRepository.findById(id)
					.orElseThrow(() -> new PrintDrawingNotFoundException("Print drawing could not be updated"));

			// Create an updated PrintDrawing entity
			PrintDrawing updatedPrintDrawing = createPrintUpdate(printDrawing, printDrawingUpdate);

			// Save the updated PrintDrawing entity
			PrintDrawing newPrintDrawing = printDrawingRepository.save(updatedPrintDrawing);
			logger.trace("Exited......updatePrint() ");
			// Map the updated PrintDrawing entity to DTO and return it
			return mapToDto(newPrintDrawing);

		} catch (PrintDrawingNotFoundException pde) {
			logger.trace("Exited......updatePrint() ");
			// Re-throw PrintDrawingNotFoundException with a more specific message
			throw new PrintDrawingNotFoundException("Print drawing could not be updated--OOp");
		}
	}

}
