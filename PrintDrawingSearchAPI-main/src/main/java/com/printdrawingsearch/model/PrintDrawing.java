package com.printdrawingsearch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The PrintDrawing class represents a print drawing entity in the system. It
 * contains all of the attributes related to the print drawing.
 */
@Entity
@Table(name = "printdrawings")
public class PrintDrawing {

	// Fields representing attributes of a print drawing
	private String bearingMax;
	private String bearingMin;
	private String customer;
	private String customerPin;
	private String customerRevision;
	private String date;
	private String dateCreated;
	private float diameterHigh;
	private float diameterLow;
	private String dmgDrawingPath;
	private String drawingName;
	private float faceLengthHigh;
	private float faceLengthLow;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String newBasePrice;
	private String oem;
	private String originatingCustomer;
	private String partNo;
	private String pdfPath;
	private String prevPartNo;
	private String productCode;
	private String revNumber;
	private String scannedPath;
	private String steps;
	private String subcontractor;
	private String type;
	private String xlsmPath;
	private String xlsxPath;

	/**
	 * Default constructor initializing all fields to default values.
	 */
	public PrintDrawing() {
		// Initialize fields
		this.xlsxPath = "";
		this.xlsmPath = "";
		this.pdfPath = "";
		this.scannedPath = "";
		this.dmgDrawingPath = "";
		this.drawingName = "";
		this.revNumber = "";
		this.diameterLow = 0.0f;
		this.diameterHigh = 0.0f;
		this.faceLengthLow = 0.0f;
		this.faceLengthHigh = 0.0f;
		this.bearingMax = "";
		this.bearingMin = "";
		this.steps = "";
		this.oem = "";
		this.type = "";
		this.customer = "";
		this.originatingCustomer = "";
		this.customerPin = "";
		this.customerRevision = "";
		this.newBasePrice = "";
		this.date = "";
		this.subcontractor = "";
		this.productCode = "";
		this.prevPartNo = "";
		this.dateCreated = "";
		this.partNo = "";
	}

	/**
	 * Parameterized constructor to initialize the PrintDrawing object with given
	 * values.
	 *
	 * @param bearingMax          the maximum bearing
	 * @param bearingMin          the minimum bearing
	 * @param customer            the customer name
	 * @param customerPin         the customer PIN
	 * @param customerRevision    the customer revision
	 * @param date                the date
	 * @param dateCreated         the date created
	 * @param diameterLow         the low diameter
	 * @param diameterHigh        the high diameter
	 * @param dmgDrawingPath      the drawing path
	 * @param drawingName         the drawing name
	 * @param faceLengthLow       the low face length
	 * @param faceLengthHigh      the high face length
	 * @param newBasePrice        the new base price
	 * @param oem                 the OEM
	 * @param originatingCustomer the originating customer
	 * @param partNo              the part number
	 * @param pdfPath             the PDF path
	 * @param prevPartNo          the previous part number
	 * @param productCode         the product code
	 * @param revNumber           the revision number
	 * @param scannedPath         the scanned path
	 * @param steps               the steps
	 * @param subcontractor       the subcontractor
	 * @param type                the type
	 * @param xlsmPath            the XLSM path
	 * @param xlsxPath            the XLSX path
	 */
	public PrintDrawing(
			String bearingMax,
			String bearingMin,
			String customer,
			String customerPin,
			String customerRevision,
			String date,
			String dateCreated,
			float diameterLow,
			float diameterHigh,
			String dmgDrawingPath,
			String drawingName,
			float faceLengthLow,
			float faceLengthHigh,
			String newBasePrice,
			String oem,
			String originatingCustomer,
			String partNo,
			String pdfPath,
			String prevPartNo,
			String productCode,
			String revNumber,
			String scannedPath,
			String steps,
			String subcontractor,
			String type,
			String xlsmPath,
			String xlsxPath) {
		super();
		this.bearingMax = bearingMax;
		this.bearingMin = bearingMin;
		this.customer = customer;
		this.customerPin = customerPin;
		this.customerRevision = customerRevision;
		this.date = date;
		this.dateCreated = dateCreated;
		this.diameterLow = diameterLow;
		this.diameterHigh = diameterHigh;
		this.dmgDrawingPath = dmgDrawingPath;
		this.drawingName = drawingName;
		this.faceLengthLow = faceLengthLow;
		this.faceLengthHigh = faceLengthHigh;
		this.newBasePrice = newBasePrice;
		this.oem = oem;
		this.originatingCustomer = originatingCustomer;
		this.partNo = partNo;
		this.pdfPath = pdfPath;
		this.prevPartNo = prevPartNo;
		this.productCode = productCode;
		this.revNumber = revNumber;
		this.scannedPath = scannedPath;
		this.steps = steps;
		this.subcontractor = subcontractor;
		this.type = type;
		this.xlsmPath = xlsmPath;
		this.xlsxPath = xlsxPath;
	}

	/**
	 * Get the maximum bearing.
	 *
	 * @return the maximum bearing
	 */
	public String getBearingMax() {
		return bearingMax;
	}

	/**
	 * Get the minimum bearing.
	 *
	 * @return the minimum bearing
	 */
	public String getBearingMin() {
		return bearingMin;
	}

	/**
	 * Get the customer name.
	 *
	 * @return the customer name
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Get the customer PIN.
	 *
	 * @return the customer PIN
	 */
	public String getCustomerPin() {
		return customerPin;
	}

	/**
	 * Get the customer revision.
	 *
	 * @return the customer revision
	 */
	public String getCustomerRevision() {
		return customerRevision;
	}

	/**
	 * Get the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Get the date created.
	 *
	 * @return the date created
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * Get the high diameter.
	 *
	 * @return the high diameter
	 */
	public float getDiameterHigh() {
		return diameterHigh;
	}

	/**
	 * Get the low diameter.
	 *
	 * @return the low diameter
	 */
	public float getDiameterLow() {
		return diameterLow;
	}

	/**
	 * Get the drawing path.
	 *
	 * @return the drawing path
	 */
	public String getDmgDrawingPath() {
		return dmgDrawingPath;
	}

	/**
	 * Get the drawing name.
	 *
	 * @return the drawing name
	 */
	public String getDrawingName() {
		return drawingName;
	}

	/**
	 * Get the high face length.
	 *
	 * @return the high face length
	 */
	public float getFaceLengthHigh() {
		return faceLengthHigh;
	}

	/**
	 * Get the low face length.
	 *
	 * @return the low face length
	 */
	public float getFaceLengthLow() {
		return faceLengthLow;
	}

	/**
	 * Get the ID.
	 *
	 * @return the ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the path of the scanned document.
	 *
	 * @return The path of the scanned document.
	 */
	public String getScannedPath() {
		return scannedPath;
	}

	/**
	 * Sets the path of the scanned document.
	 *
	 * @param scannedPath The path of the scanned document.
	 */
	public void setScannedPath(String scannedPath) {
		this.scannedPath = scannedPath;
	}

	/**
	 * Gets the steps involved in the process.
	 *
	 * @return The steps involved in the process.
	 */
	public String getSteps() {
		return steps;
	}

	/**
	 * Sets the steps involved in the process.
	 *
	 * @param steps The steps involved in the process.
	 */
	public void setSteps(String steps) {
		this.steps = steps;
	}

	/**
	 * Gets the subcontractor involved.
	 *
	 * @return The subcontractor involved.
	 */
	public String getSubcontractor() {
		return subcontractor;
	}

	/**
	 * Sets the subcontractor involved.
	 *
	 * @param subcontractor The subcontractor involved.
	 */
	public void setSubcontractor(String subcontractor) {
		this.subcontractor = subcontractor;
	}

	/**
	 * Gets the type of the document.
	 *
	 * @return The type of the document.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the document.
	 *
	 * @param type The type of the document.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the path of the XLSM file.
	 *
	 * @return The path of the XLSM file.
	 */
	public String getXlsmPath() {
		return xlsmPath;
	}

	/**
	 * Sets the path of the XLSM file.
	 *
	 * @param xlsmPath The path of the XLSM file.
	 */
	public void setXlsmPath(String xlsmPath) {
		this.xlsmPath = xlsmPath;
	}

	/**
	 * Gets the path of the XLSX file.
	 *
	 * @return The path of the XLSX file.
	 */
	public String getXlsxPath() {
		return xlsxPath;
	}

	/**
	 * Sets the path of the XLSX file.
	 *
	 * @param xlsxPath The path of the XLSX file.
	 */
	public void setXlsxPath(String xlsxPath) {
		this.xlsxPath = xlsxPath;
	}

	/**
	 * Get the new base price.
	 *
	 * @return the new base price
	 */
	public String getNewBasePrice() {
		return newBasePrice;
	}

	/**
	 * Get the OEM.
	 *
	 * @return the OEM
	 */
	public String getOem() {
		return oem;
	}

	/**
	 * Get the originating customer.
	 *
	 * @return the originating customer
	 */
	public String getOriginatingCustomer() {
		return originatingCustomer;
	}

	/**
	 * Get the part number.
	 *
	 * @return the part number
	 */
	public String getPartNo() {
		return partNo;
	}

	/**
	 * Get the PDF path.
	 *
	 * @return the PDF path
	 */
	public String getPdfPath() {
		return pdfPath;
	}

	/**
	 * Get the previous part number.
	 *
	 * @return the previous part number
	 */
	public String getPrevPartNo() {
		return prevPartNo;
	}

	/**
	 * Get the product code.
	 *
	 * @return the product code
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Get the revision number.
	 *
	 * @return the revision number
	 */
	public String getRevNumber() {
		return revNumber;
	}

	/**
	 * Set the maximum bearing.
	 *
	 * @param bearingMax the maximum bearing to set
	 */
	public void setBearingMax(String bearingMax) {
		this.bearingMax = bearingMax;
	}

	/**
	 * Set the minimum bearing.
	 *
	 * @param bearingMin the minimum bearing to set
	 */
	public void setBearingMin(String bearingMin) {
		this.bearingMin = bearingMin;
	}

	/**
	 * Set the customer name.
	 *
	 * @param customer the customer name to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Set the customer PIN.
	 *
	 * @param customerPin the customer PIN to set
	 */
	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	/**
	 * Set the customer revision.
	 *
	 * @param customerRevision the customer revision to set
	 */
	public void setCustomerRevision(String customerRevision) {
		this.customerRevision = customerRevision;
	}

	/**
	 * Set the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Set the date created.
	 *
	 * @param dateCreated the date created to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Set the high diameter.
	 *
	 * @param diameterHigh the high diameter to set
	 */
	public void setDiameterHigh(float diameterHigh) {
		this.diameterHigh = diameterHigh;
	}

	/**
	 * Set the low diameter.
	 *
	 * @param diameterLow the low diameter to set
	 */
	public void setDiameterLow(float diameterLow) {
		this.diameterLow = diameterLow;
	}

	/**
	 * Set the drawing path.
	 *
	 * @param dmgDrawingPath the drawing path to set
	 */
	public void setDmgDrawingPath(String dmgDrawingPath) {
		this.dmgDrawingPath = dmgDrawingPath;
	}

	/**
	 * Set the drawing name.
	 *
	 * @param drawingName the drawing name to set
	 */
	public void setDrawingName(String drawingName) {
		this.drawingName = drawingName;
	}

	/**
	 * Set the high face length.
	 *
	 * @param faceLengthHigh the high face length to set
	 */
	public void setFaceLengthHigh(float faceLengthHigh) {
		this.faceLengthHigh = faceLengthHigh;
	}

	/**
	 * Set the low face length.
	 *
	 * @param faceLengthLow the low face length to set
	 */
	public void setFaceLengthLow(float faceLengthLow) {
		this.faceLengthLow = faceLengthLow;
	}

	/**
	 * Set the ID.
	 *
	 * @param id the ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set the new base price.
	 *
	 * @param newBasePrice the new base price to set
	 */
	public void setNewBasePrice(String newBasePrice) {
		this.newBasePrice = newBasePrice;
	}

	/**
	 * Set the OEM.
	 *
	 * @param oem the OEM to set
	 */
	public void setOem(String oem) {
		this.oem = oem;
	}

	/**
	 * Set the originating customer.
	 *
	 * @param originatingCustomer the originating customer to set
	 */
	public void setOriginatingCustomer(String originatingCustomer) {
		this.originatingCustomer = originatingCustomer;
	}

	/**
	 * Set the part number.
	 *
	 * @param partNo the part number to set
	 */
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	/**
	 * Set the PDF path.
	 *
	 * @param pdfPath the PDF path to set
	 */
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	/**
	 * Set the previous part number.
	 *
	 * @param prevPartNo the previous part number to set
	 */
	public void setPrevPartNo(String prevPartNo) {
		this.prevPartNo = prevPartNo;
	}

	/**
	 * Set the product code.
	 *
	 * @param productCode the product code to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * Set the revision number.
	 *
	 * @param revNumber the revision number to set
	 */
	public void setRevNumber(String revNumber) {
		this.revNumber = revNumber;
	}

}