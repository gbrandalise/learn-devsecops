package com.neo.learn.presentation.stress.cpu;

import org.springframework.stereotype.Service;

@Service
public class StressCpuService {

	public void test() {
		int cores = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[cores];
        for (int i = 0; i < cores; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    Math.sin(Math.cos(Math.sin(Math.cos(0.123))));
                }
            });
            threads[i].start();
        }
	}

}
