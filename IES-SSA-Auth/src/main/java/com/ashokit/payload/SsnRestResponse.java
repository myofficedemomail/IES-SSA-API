package com.ashokit.payload;

import lombok.Data;

@Data
public class SsnRestResponse {
	private String city;
	private String dob;
	private String fullname;
	private String gender;
	private String houseNum;
	private String ssn;
	private String state;
}
