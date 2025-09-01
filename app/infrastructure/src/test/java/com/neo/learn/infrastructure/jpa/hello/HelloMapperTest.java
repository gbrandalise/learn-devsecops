package com.neo.learn.infrastructure.jpa.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.neo.learn.domain.hello.Hello;

class HelloMapperTest {

    private final HelloMapper mapper = HelloMapper.INSTANCE;

    @Test
    void testToEntity_MapsIdAndName() {
        HelloJpaEntity jpa = new HelloJpaEntity(123L, "Alice");

        Hello hello = mapper.toEntity(jpa);

        assertNotNull(hello);
        assertEquals(123L, hello.getId());
        assertEquals("Alice", hello.getName());
    }

    @Test
    void testToJpa_MapsIdAndName() {
        Hello hello = new Hello(456L, "Bob");

        HelloJpaEntity jpa = mapper.toJpa(hello);

        assertNotNull(jpa);
        assertEquals(456L, jpa.getId());
        assertEquals("Bob", jpa.getName());
    }

    @Test
    void testRoundTrip_JpaToDomainToJpa_PreservesValues() {
        HelloJpaEntity original = new HelloJpaEntity(789L, "Carol");

        Hello domain = mapper.toEntity(original);
        HelloJpaEntity roundTrip = mapper.toJpa(domain);

        assertNotNull(roundTrip);
        assertEquals(original.getId(), roundTrip.getId());
        assertEquals(original.getName(), roundTrip.getName());
    }

    @Test
    void testToEntity_ReturnsNullOnNullInput() {
        assertNull(mapper.toEntity(null));
    }

    @Test
    void testToJpa_ReturnsNullOnNullInput() {
        assertNull(mapper.toJpa(null));
    }

    @Test
    void testMapping_PreservesNullPropertiesWithoutException() {
        // JPA -> Domain with null id
        HelloJpaEntity jpaWithNullId = new HelloJpaEntity(null, "Neo");
        Hello domainFromNullId = mapper.toEntity(jpaWithNullId);
        assertNotNull(domainFromNullId);
        assertNull(domainFromNullId.getId());
        assertEquals("Neo", domainFromNullId.getName());

        // Domain -> JPA with null id
        Hello domainWithNullName = new Hello(null, "Neo");
        HelloJpaEntity jpaFromNullName = mapper.toJpa(domainWithNullName);
        assertNotNull(jpaFromNullName);
        assertNull(jpaFromNullName.getId());
        assertEquals("Neo", jpaFromNullName.getName());
    }
}