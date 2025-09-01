package com.neo.learn.infrastructure.jpa.hello;

import com.neo.learn.domain.mapstruct.Default;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hello")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
class HelloJpaEntity {

	@Id
	private Long id;
	@Setter
	@NonNull
	private String name;

	@Default
	public HelloJpaEntity(Long id, String name) {
		this(name);
		this.id = id;
	}

}
