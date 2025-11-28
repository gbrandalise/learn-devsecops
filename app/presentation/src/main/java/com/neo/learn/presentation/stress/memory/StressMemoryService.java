package com.neo.learn.presentation.stress.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StressMemoryService {

	public void test() {
		List<byte[]> list = new ArrayList<>();
        for (int i = 0;i < 10;i++) { // 10 iteracoes = ~1GB
            byte[] b = new byte[100_000_000]; // ~100MB por iteração
            list.add(b);
        }
	}

}
