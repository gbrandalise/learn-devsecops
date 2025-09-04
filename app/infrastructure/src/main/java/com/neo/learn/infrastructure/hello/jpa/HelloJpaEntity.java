package com.neo.learn.infrastructure.hello.jpa;

import com.neo.learn.domain.common.Default;

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
public class HelloJpaEntity {

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
