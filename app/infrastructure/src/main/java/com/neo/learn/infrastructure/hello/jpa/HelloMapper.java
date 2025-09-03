package com.neo.learn.infrastructure.hello.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.neo.learn.domain.hello.Hello;

@Mapper(componentModel = "spring")
public interface HelloMapper {

	HelloMapper INSTANCE = Mappers.getMapper(HelloMapper.class);

	Hello toEntity(HelloJpaEntity jpaEntity);

	HelloJpaEntity toJpa(Hello entity);

}
