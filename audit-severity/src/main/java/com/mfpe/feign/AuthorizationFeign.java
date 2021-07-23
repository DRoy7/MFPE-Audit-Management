package com.mfpe.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.model.AuthenticationResponse;

@FeignClient(name="Authorization-Ms", url = "${ms.auth}")
public interface AuthorizationFeign{

	@GetMapping("/validate")
	public ResponseEntity<AuthenticationResponse> validate(@RequestHeader("Authorization") String jwt);

}
