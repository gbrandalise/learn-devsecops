package com.neo.learn.presentation.stress;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neo.learn.presentation.stress.cpu.StressCpuService;
import com.neo.learn.presentation.stress.memory.StressMemoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("stress")
@RequiredArgsConstructor
public class StressController {

	private final StressCpuService stressCpu;
	private final StressMemoryService stressMemory;

	@GetMapping("cpu")
	public String cpu() {
		stressCpu.test();
		return "/index.html";
	}

	@GetMapping("memory")
	public String memory() {
		stressMemory.test();
		return "/index.html";
	}

}
