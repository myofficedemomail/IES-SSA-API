package com.ashokit.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.ashokit.payload.ApplicationRegnDto;
import com.ashokit.payload.SsnRestResponse;

@Service
public class SSAAuthServiceImpl implements SSAAuthService {
	String[] houseNum = { "519 Front  East 12th Street   (Manhattan)", "625 Rear  Smith Street   (Brooklyn)",
			"120 1/2  First Avenue   (Manhattan)", "240-55 1/3  Depew Avenue   (Queens)",
			"469 1/4  Father Capodanno Boulevard   (Staten Island)", "470 A  West 43rd Street   (Manhattan)",
			"171C  Auburn Avenue   (Staten Island)", "20-29 Garage  120th Street   (Queens)" };
	String[] states = { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
			"Florida       ", "Georgia     ", "Hawaii      ", "Idaho         ", "Illinois      ", "Indiana     ",
			"Iowa        ", "Kansas        ", "Kentucky      ", "Louisiana   ", "Maine       ", "Maryland      ",
			"Massachusetts ", "Michigan    ", "Minnesota   ", "Mississippi   ", "Missouri      ", "Montana     ",
			"Nebraska    ", "Nevada        ", "New Hampshire ", "New Jersey  ", "New Mexico  ", "New York      ",
			"North Carolina", "North Dakota", "Ohio        ", "Oklahoma      ", "Oregon        ", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota  ", "Tennessee   ", "Texas       ", "Utah          ",
			"Vermont       ", "Virginia    ", "Washington  ", "West Virginia ", "Wisconsin     ", "Wyoming     " };
	String[] cities = { "New York City ", "Los Angeles	", "Chicago	   ", "Houston	   ", "Phoenix	   ",
			"Philadelphia  ", "San Antonio	", "San Diego	   ", "Dallas		   ", "San Jose	   ",
			"Austin		   ", "Jacksonville  ", "Fort Worth	   ", "Columbus	   ", "Indianapolis  ", "Charlotte	   ",
			"San Francisc  ", "Louisville	   ", "Seattle		", "Nashville	   ", "Denver		   ",
			"Washington	   ", "Oklahoma      ", "El Paso	   ", "Boston	       ", "Portland	   ",
			"Las Vegas	   ", "Detroit	   ", "Memphis	   ", "Baltimore	   ", "Milwaukee	   ", "Albuquerque	",
			"Tucson	       ", "Fresno	       ", "Sacramento	   ", "Kansas City	", "Mesa	       ",
			"Atlanta	   ", "Omaha	       ", "Colorado      ", "Raleigh	   ", "Long Beach	   ",
			"Virginia      ", "Miami	       ", "Oakland	   ", "Minneapolis   ", "Tulsa         ", "Bakersfield   ",
			"Wichita	   ", "Arlington     " };

	@Override
	public SsnRestResponse ssaDtls(ApplicationRegnDto applicationRegnDto) {
		Random r = new Random();
		int stateLow = 0;
		int stateHigh = states.length - 1;
		int stateResult = r.nextInt(stateHigh - stateLow) + stateLow;

		int houseNumLow = 0;
		int houseNumHigh = houseNum.length - 1;
		int houseNumResult = r.nextInt(houseNumHigh - houseNumLow) + houseNumLow;

		int cityLow = 0;
		int cityHigh = cities.length - 1;
		int cityResult = r.nextInt(cityHigh - cityLow) + cityLow;

		SsnRestResponse ssnRestResponse = null;
		if (applicationRegnDto == null) {
			return new SsnRestResponse();
		} else {
			if (applicationRegnDto.getSsn().charAt(0) == '5') {
				ssnRestResponse = new SsnRestResponse();
				ssnRestResponse.setCity(cities[cityResult].trim());
				ssnRestResponse.setDob(applicationRegnDto.getDob());
				ssnRestResponse.setFullname(applicationRegnDto.getFullname());
				ssnRestResponse.setGender(applicationRegnDto.getGender());
				ssnRestResponse.setHouseNum(houseNum[houseNumResult].trim());
				ssnRestResponse.setSsn(applicationRegnDto.getSsn());
				ssnRestResponse.setState("Rhode Island");

			} else {
				ssnRestResponse = new SsnRestResponse();
				ssnRestResponse.setCity(cities[cityResult].trim());
				ssnRestResponse.setDob(applicationRegnDto.getDob());
				ssnRestResponse.setFullname(applicationRegnDto.getFullname());
				ssnRestResponse.setGender(applicationRegnDto.getGender());
				ssnRestResponse.setHouseNum(houseNum[houseNumResult].trim());
				ssnRestResponse.setSsn(applicationRegnDto.getSsn());
				ssnRestResponse.setState(states[stateResult].trim());
			}
		}
		return ssnRestResponse;
	}

}
