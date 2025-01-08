package com.mayer.resilience.service;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class ResilientService {

	@Retry(name = "unstableService", fallbackMethod = "fallbackMethod")
	public String unstableOperation() {
		if (Math.random() < 0.5) {
			throw new RuntimeException("Service failure");
		}
		return "Success";
	}

	public String fallbackMethod(Throwable t) {
		System.out.println("blastoise error");
		return "Fallback response due to failure";
	}
}
