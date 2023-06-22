package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.payload.ApplicationRegnDto;
import com.ashokit.payload.SsnRestResponse;
import com.ashokit.service.SSAAuthService;

@RestController
@RequestMapping(value = "ssa")
public class SSAAuthController {
	@Autowired
	private SSAAuthService ssaAuthService;
	@PostMapping("citizen")
	public ResponseEntity<SsnRestResponse> ssaDtls(@RequestBody ApplicationRegnDto applicationRegnDto) {
		SsnRestResponse ssaDtls = ssaAuthService.ssaDtls(applicationRegnDto);
		return new ResponseEntity<SsnRestResponse>(ssaDtls, HttpStatus.OK);
	}
}
