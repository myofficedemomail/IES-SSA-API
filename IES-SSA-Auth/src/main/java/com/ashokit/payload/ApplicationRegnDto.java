package com.ashokit.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ApplicationRegnDto {
	@NotEmpty(message = "Dob Can Not Be Empty")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "Invalid Date Format. Format Should Be yyyy-mm-dd")
	private String dob;
	@NotEmpty(message = "Case Worker Name Can Not Be Empty")
	@Size(min = 4, max = 25, message = "Case Worker Name Should Be Between 4 To 25 Characters")
	private String fullname;
	@Pattern(regexp = "(?:m|M|f|F)$", message = "Gender Should Be M/F Format")
	private String gender;
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{9})", message = "SSN Number Should Be 9 Digits")
	private String ssn;
}
