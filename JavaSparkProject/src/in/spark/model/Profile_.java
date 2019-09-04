package in.spark.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Profile_ implements Serializable {

	public Profile_() {

	}

	public Profile_(String userId, String jobTitleName, String firstName, String lastName, String preferredFullName,
			String employeeCode, String region, String phoneNumber, String emailAddress, List<Address> address) {
		super();
		this.userId = userId;
		this.jobTitleName = jobTitleName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredFullName = preferredFullName;
		this.employeeCode = employeeCode;
		this.region = region;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	private String userId;

	private String jobTitleName;

	private String firstName;

	private String lastName;

	private String preferredFullName;

	private String employeeCode;

	private String region;

	private String phoneNumber;

	private String emailAddress;

	private List<Address> address = new ArrayList<Address>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}

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

	public String getPreferredFullName() {
		return preferredFullName;
	}

	public void setPreferredFullName(String preferredFullName) {
		this.preferredFullName = preferredFullName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("userId", userId).append("jobTitleName", jobTitleName)
				.append("firstName", firstName).append("lastName", lastName)
				.append("preferredFullName", preferredFullName).append("employeeCode", employeeCode)
				.append("region", region).append("phoneNumber", phoneNumber).append("emailAddress", emailAddress)
				.append("address", address).toString();
	}

}
