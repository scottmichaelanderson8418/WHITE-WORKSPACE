package com.printdrawingsearchapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The @JsonPropertyOrder annotation is used to define the order in which fields are serialized to JSON when the object
 * is returned in the API response.
 */
@JsonPropertyOrder({ "id", "drawingName", "customer", "oem", "diameter", "faceLength", "bearingMin", "bearingMax",
		"customerPin", "customerRevision", "date", "dateCreated", "dmgDrawingPath", "id", "newBasePrice",
		"originatingCustomer", "partNo", "pdfPath", "prevPartNo", "productCode", "revNumber", "scannedPath", "steps",
		"subcontractor", "type", "xlsmPath", "xlsxPath" })

/**
 * The PrintDrawingDto class is a data transfer object that represents the Print Drawing entity. This class is used to
 * transfer data between different layers of the application.
 */
public class PrintDrawingDto {

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
	 * Default constructor initializes fields to default values.
	 */
	public PrintDrawingDto() {
		// Initialize fields
		this.xlsxPath = "";
		this.xlsmPath = "";
		this.pdfPath = "";
		this.scannedPath = "";
		this.dmgDrawingPath = "";
		this.drawingName = "";
		this.revNumber = "";
		this.diameterHigh = 0.0f;
		this.diameterLow = 0.0f;
		this.faceLengthHigh = 0.0f;
		this.faceLengthLow = 0.0f;
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

	public PrintDrawingDto(
			String bearingMax,
			String bearingMin,
			String customer,
			String customerPin,
			String customerRevision,
			String date,
			String dateCreated,
			float diameterHigh,
			float diameterLow,
			String dmgDrawingPath,
			String drawingName,
			float faceLengthHigh,
			float faceLengthLow,
			int id,
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
		this.diameterHigh = diameterHigh;
		this.diameterLow = diameterLow;
		this.dmgDrawingPath = dmgDrawingPath;
		this.drawingName = drawingName;
		this.faceLengthHigh = faceLengthHigh;
		this.faceLengthLow = faceLengthLow;
		this.id = id;
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
	 * Gets the bearing max.
	 *
	 * @return the maximum bearing
	 */
	public String getBearingMax() {
		return bearingMax;
	}

	/**
	 * Gets the bearing min.
	 *
	 * @return the minimum bearing
	 */
	public String getBearingMin() {
		return bearingMin;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer name
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Gets the customer pin.
	 *
	 * @return the customer pin
	 */
	public String getCustomerPin() {
		return customerPin;
	}

	/**
	 * Gets the customer revision.
	 *
	 * @return the customer revision
	 */
	public String getCustomerRevision() {
		return customerRevision;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * Overloaded constructor to initialize fields with specific values.
	 *
	 * @param bearingMax          the bearing max
	 * @param bearingMin          the bearing min
	 * @param customer            the customer
	 * @param customerPin         the customer pin
	 * @param customerRevision    the customer revision
	 * @param date                the date
	 * @param dateCreated         the date created
	 * @param diameter            the diameter
	 * @param dmgDrawingPath      the dmg drawing path
	 * @param drawingName         the drawing name
	 * @param faceLength          the face length
	 * @param newBasePrice        the new base price
	 * @param oem                 the oem
	 * @param originatingCustomer the originating customer
	 * @param partNo              the part no
	 * @param pdfPath             the pdf path
	 * @param prevPartNo          the prev part no
	 * @param productCode         the product code
	 * @param revNumber           the rev number
	 * @param scannedPath         the scanned path
	 * @param steps               the steps
	 * @param subcontractor       the subcontractor
	 * @param type                the type
	 * @param xlsmPath            the xlsm path
	 * @param xlsxPath            the xlsx path
	 */

	// Getter and Setter methods with Javadoc comments

	public float getDiameterHigh() {
		return diameterHigh;
	}

	public float getDiameterLow() {
		return diameterLow;
	}

	/**
	 * Gets the dmg drawing path.
	 *
	 * @return the DMG drawing path
	 */
	public String getDmgDrawingPath() {
		return dmgDrawingPath;
	}

	/**
	 * Gets the drawing name.
	 *
	 * @return the drawing name
	 */
	public String getDrawingName() {
		return drawingName;
	}

	public float getFaceLengthHigh() {
		return faceLengthHigh;
	}

	public float getFaceLengthLow() {
		return faceLengthLow;
	}

	/**
	 * Gets the id.
	 *
	 * @return the ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the new base price.
	 *
	 * @return the new base price
	 */
	public String getNewBasePrice() {
		return newBasePrice;
	}

	/**
	 * Gets the oem.
	 *
	 * @return the OEM
	 */
	public String getOem() {
		return oem;
	}

	/**
	 * Gets the originating customer.
	 *
	 * @return the originating customer
	 */
	public String getOriginatingCustomer() {
		return originatingCustomer;
	}

	/**
	 * Gets the part no.
	 *
	 * @return the part number
	 */
	public String getPartNo() {
		return partNo;
	}

	/**
	 * Gets the pdf path.
	 *
	 * @return the PDF path
	 */
	public String getPdfPath() {
		return pdfPath;
	}

	/**
	 * Gets the prev part no.
	 *
	 * @return the previous part number
	 */
	public String getPrevPartNo() {
		return prevPartNo;
	}

	/**
	 * Gets the product code.
	 *
	 * @return the product code
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Gets the rev number.
	 *
	 * @return the revision number
	 */
	public String getRevNumber() {
		return revNumber;
	}

	/**
	 * Gets the scanned path.
	 *
	 * @return the scanned path
	 */
	public String getScannedPath() {
		return scannedPath;
	}

	/**
	 * Gets the steps.
	 *
	 * @return the steps
	 */
	public String getSteps() {
		return steps;
	}

	/**
	 * Gets the subcontractor.
	 *
	 * @return the subcontractor
	 */
	public String getSubcontractor() {
		return subcontractor;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Gets the xlsm path.
	 *
	 * @return the XLSM path
	 */
	public String getXlsmPath() {
		return xlsmPath;
	}

	/**
	 * Gets the xlsx path.
	 *
	 * @return the XLSX path
	 */
	public String getXlsxPath() {
		return xlsxPath;
	}

	/**
	 * Sets the bearing max.
	 *
	 * @param bearingMax the maximum bearing to set
	 */
	public void setBearingMax(String bearingMax) {
		this.bearingMax = bearingMax;
	}

	/**
	 * Sets the bearing min.
	 *
	 * @param bearingMin the minimum bearing to set
	 */
	public void setBearingMin(String bearingMin) {
		this.bearingMin = bearingMin;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the customer name to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Sets the customer pin.
	 *
	 * @param customerPin the customer pin to set
	 */
	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	/**
	 * Sets the customer revision.
	 *
	 * @param customerRevision the customer revision to set
	 */
	public void setCustomerRevision(String customerRevision) {
		this.customerRevision = customerRevision;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Sets the date created.
	 *
	 * @param dateCreated the date created to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setDiameterHigh(float diameterHigh) {
		this.diameterHigh = diameterHigh;
	}

	public void setDiameterLow(float diameterLow) {
		this.diameterLow = diameterLow;
	}

	/**
	 * Sets the dmg drawing path.
	 *
	 * @param dmgDrawingPath the DMG drawing path to set
	 */
	public void setDmgDrawingPath(String dmgDrawingPath) {
		this.dmgDrawingPath = dmgDrawingPath;
	}

	/**
	 * Sets the drawing name.
	 *
	 * @param drawingName the drawing name to se
	 */
	public void setDrawingName(String drawingName) {
		this.drawingName = drawingName;
	}

	public void setFaceLengthHigh(float faceLengthHigh) {
		this.faceLengthHigh = faceLengthHigh;
	}

	public void setFaceLengthLow(float faceLengthLow) {
		this.faceLengthLow = faceLengthLow;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the new base price.
	 *
	 * @param newBasePrice th new base price to set
	 */
	public void setNewBasePrice(String newBasePrice) {
		this.newBasePrice = newBasePrice;
	}

	/**
	 * Sets the oem.
	 *
	 * @param oem the OEM t set
	 */
	public void setOem(String oem) {
		this.oem = oem;
	}

	/**
	 * Sets the originating customer.
	 *
	 * @param originatingCustomer the originating customer to set
	 */
	public void setOriginatingCustomer(String originatingCustomer) {
		this.originatingCustomer = originatingCustomer;
	}

	/**
	 * Sets the part no.
	 *
	 * @param partNo the part number to set
	 */
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	/**
	 * Sets the pdf path.
	 *
	 * @param pdfPath the PDF path to set
	 */
	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	/**
	 * Sets the prev part no.
	 *
	 * @param prevPartNo the previous part number to set
	 */
	public void setPrevPartNo(String prevPartNo) {
		this.prevPartNo = prevPartNo;
	}

	/**
	 * Sets the product code.
	 *
	 * @param productCode the product code to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * Sets the rev number.
	 *
	 * @param revNumber the revison number to set
	 */
	public void setRevNumber(String revNumber) {
		this.revNumber = revNumber;
	}

	/**
	 * Sets the scanned path.
	 *
	 * @param scannedPath the scanned path to set
	 */
	public void setScannedPath(String scannedPath) {
		this.scannedPath = scannedPath;
	}

	/**
	 * Sets the steps.
	 *
	 * @param steps the steps to set
	 */
	public void setSteps(String steps) {
		this.steps = steps;
	}

	/**
	 * Sets the subcontractor.
	 *
	 * @param subcontractor the subcontractor to set
	 */
	public void setSubcontractor(String subcontractor) {
		this.subcontractor = subcontractor;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Sets the xlsm path.
	 *
	 * @param xlsmPath the XLSM path to set
	 */
	public void setXlsmPath(String xlsmPath) {
		this.xlsmPath = xlsmPath;
	}

	/**
	 * Sets the xlsx path.
	 *
	 * @param xlsxPath the XLSX path to set
	 */
	public void setXlsxPath(String xlsxPath) {
		this.xlsxPath = xlsxPath;
	}

	/**
	 * Returns a string representation of the PrintDrawingDto object.
	 * 
	 * @return a string representation of the object
	 */

	@Override
	public String toString() {
		return "PrintDrawingDto [bearingMax=" + bearingMax + ", bearingMin=" + bearingMin + ", customer=" + customer +
				", customerPin=" + customerPin + ", customerRevision=" + customerRevision + ", date=" + date +
				", dateCreated=" + dateCreated + ", diameterHigh=" + diameterHigh + ", diameterLow=" + diameterLow +
				", dmgDrawingPath=" + dmgDrawingPath + ", drawingName=" + drawingName + ", faceLengthHigh=" +
				faceLengthHigh + ", faceLengthLow=" + faceLengthLow + ", id=" + id + ", newBasePrice=" + newBasePrice +
				", oem=" + oem + ", originatingCustomer=" + originatingCustomer + ", partNo=" + partNo + ", pdfPath=" +
				pdfPath + ", prevPartNo=" + prevPartNo + ", productCode=" + productCode + ", revNumber=" + revNumber +
				", scannedPath=" + scannedPath + ", steps=" + steps + ", subcontractor=" + subcontractor + ", type=" +
				type + ", xlsmPath=" + xlsmPath + ", xlsxPath=" + xlsxPath + "]";
	}

}
