package com.neo.learn.infrastructure.hello;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.neo.learn.application.hello.HelloRepository;
import com.neo.learn.domain.hello.Hello;
import com.neo.learn.infrastructure.hello.jpa.HelloJpaEntity;
import com.neo.learn.infrastructure.hello.jpa.HelloJpaRepository;
import com.neo.learn.infrastructure.hello.jpa.HelloMapper;

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
