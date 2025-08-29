package com.neo.learn.infrastructure.jpa.hello;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.neo.learn.application.hello.HelloRepository;
import com.neo.learn.domain.hello.Hello;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class HelloRepositoryImpl implements HelloRepository {

	private final HelloJpaRepository jpaRepository;
	private final HelloMapper helloMapper;

	@Override
	public Optional<Hello> findById(@NonNull Long id) {
		Optional<HelloJpaEntity> entity = jpaRepository.findById(id);
		return entity.map(helloMapper::toEntity);
	}

}
