package com.neo.learn.infrastructure.hello.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloJpaRepository extends JpaRepository<HelloJpaEntity, Long> {

}
