package com.neo.learn.infrastructure.jpa.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HelloJpaRepository extends JpaRepository<HelloJpaEntity, Long> {

}
