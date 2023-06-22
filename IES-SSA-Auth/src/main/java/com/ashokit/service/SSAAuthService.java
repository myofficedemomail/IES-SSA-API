package com.ashokit.service;

import com.ashokit.payload.ApplicationRegnDto;
import com.ashokit.payload.SsnRestResponse;

public interface SSAAuthService {
	public SsnRestResponse ssaDtls(ApplicationRegnDto applicationRegnDto);
}
