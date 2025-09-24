package com.neo.learn.presentation.probe;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("probe")
@RequiredArgsConstructor
public class ProbeController {

	private final ApplicationEventPublisher publisher;

	@GetMapping("liveness/down")
	public String down() {
		AvailabilityChangeEvent.publish(publisher, this, LivenessState.BROKEN);
		return "/probes.html";
	}

	@GetMapping("liveness/up")
	public String up() {
		AvailabilityChangeEvent.publish(publisher, this, LivenessState.CORRECT);
		return "/probes.html";
	}

}
