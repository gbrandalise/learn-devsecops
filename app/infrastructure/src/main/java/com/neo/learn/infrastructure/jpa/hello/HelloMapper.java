package com.neo.learn.infrastructure.jpa.hello;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.neo.learn.domain.hello.Hello;

@Mapper(componentModel = "spring")
interface HelloMapper {

	HelloMapper INSTANCE = Mappers.getMapper(HelloMapper.class);

	Hello toEntity(HelloJpaEntity jpaEntity);

	HelloJpaEntity toJpa(Hello entity);

}
