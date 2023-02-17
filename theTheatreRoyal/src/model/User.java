package model;

public class User {

	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postcode;
	private String email;
	private String phoneNo;
	private String ccNo;
	private boolean isEmployee;

	/**
	 * Main constructor used for creating new members
	 * 
	 * @param firstName
	 * @param lastName
	 * @param streetName
	 * @param city
	 * @param postcode
	 * @param userReferenceID
	 * @param email
	 * @param ccNumber
	 */
	public User() {

		this.firstName = null;
		this.lastName = null;
		this.addressLine1 = null;
		this.addressLine2 = null;
		this.city = null;
		this.postcode = null;
		this.email = null;
		this.phoneNo = null;
		this.ccNo = null;
		this.isEmployee = false;

	}

	/**
	 * generated getters and setters
	 *
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCcNumber() {
		return ccNo;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNo = ccNumber;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}
