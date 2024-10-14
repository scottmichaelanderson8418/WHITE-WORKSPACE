package com.printdrawingsearch.dto;

import java.util.List;

/**
 * The PrintDrawing Response is used to send information about the pagination
 * details when returning a response to the user.
 */
public class PrintDrawingResponse {

	/** The content. */
	private List<PrintDrawingDto> content;

	/** The last. */
	private boolean last;

	/** The page no. */
	private int pageNo;

	/** The page size. */
	private int pageSize;

	/** The total elements. */
	private long totalElements;

	/** The total pages. */
	private int totalPages;

	/**
	 * Default constructor.
	 */
	public PrintDrawingResponse() {

	}

	/**
	 * Constructor with all fields.
	 *
	 * @param content       the content of the current page
	 * @param pageNo        the current page number
	 * @param pageSize      the size of the page
	 * @param totalElements the total number of elements
	 * @param totalPages    the total number of pages
	 * @param last          indicates if this is the last page
	 */
	public PrintDrawingResponse(
			List<PrintDrawingDto> content,
			int pageNo,
			int pageSize,
			long totalElements,
			int totalPages,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content of the current page
	 */
	public List<PrintDrawingDto> getContent() {
		return content;
	}

	/**
	 * Gets the page no.
	 *
	 * @return the current page number
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the size of the page
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Gets the total elements.
	 *
	 * @return the total number of elements
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * Gets the total pages.
	 *
	 * @return the total number of pages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * Gets the last.
	 *
	 * @return true if this is the last page, false otherwise
	 */
	public boolean getLast() {
		return last;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the content to set
	 */
	public void setContent(List<PrintDrawingDto> content) {
		this.content = content;
	}

	/**
	 * Sets the last.
	 *
	 * @param last indicates if this is the last page to set
	 */
	public void setLast(boolean last) {
		this.last = last;
	}

	/**
	 * Sets the page no.
	 *
	 * @param pageNo the page number to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the page size to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Sets the total elements.
	 *
	 * @param totalElements the total number of elements to set
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * Sets the total pages.
	 *
	 * @param totalPages the total number of pages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
