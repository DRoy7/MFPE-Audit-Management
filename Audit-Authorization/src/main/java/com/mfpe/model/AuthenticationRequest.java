package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class AuthenticationRequest {
	private String username;
	private String password;
}
