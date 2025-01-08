package com.mayer.resilience.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayer.resilience.service.ResilientService;

@RestController
public class ResilientController {

	private final ResilientService resilientService;

	public ResilientController(ResilientService resilientService) {
		this.resilientService = resilientService;
	}

	@GetMapping("/test")
	public String testEndpoint() {
		try {
			return resilientService.unstableOperation();
		} catch (RuntimeException e) {
			return "Service failed, please try again later.";
		}
	}
}
