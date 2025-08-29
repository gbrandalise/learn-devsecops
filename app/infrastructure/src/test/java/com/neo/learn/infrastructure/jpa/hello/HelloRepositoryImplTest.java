package com.neo.learn.infrastructure.jpa.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import com.neo.learn.domain.hello.Hello;

@ExtendWith(MockitoExtension.class)
class HelloRepositoryImplTest {

    @Mock
    private HelloJpaRepository jpaRepository;

	@Spy
	private HelloMapper helloMapper = HelloMapper.INSTANCE;

	@InjectMocks
    private HelloRepositoryImpl repository;

    @Test
    void testFindByIdReturnsMappedDomainWhenEntityExists() {
        Long id = 42L;
		String name = "Test";
        HelloJpaEntity jpaEntity = new HelloJpaEntity(id, name);

        when(jpaRepository.findById(id)).thenReturn(Optional.of(jpaEntity));

        Optional<Hello> result = repository.findById(id);

        assertTrue(result.isPresent());
        assertEquals(name, result.get().getName());
        verify(jpaRepository).findById(id);
    }

    @Test
    void testFindByIdReturnsEmptyWhenEntityNotFoundAndDoesNotInvokeMapper() {
        Long id = 100L;
        when(jpaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Hello> result = repository.findById(id);

        assertTrue(result.isEmpty());
        verify(jpaRepository).findById(id);
		verifyNoInteractions(helloMapper);
    }

    @Test
    void testFindByIdWithNullIdThrowsIllegalArgumentException() {
        assertThrows(NullPointerException.class, () -> repository.findById(null));
    }

    @Test
    void testFindByIdPropagatesDataAccessExceptionFromRepository() {
        Long id = 7L;
        DataAccessException dae = new DataAccessResourceFailureException("db down");
        when(jpaRepository.findById(id)).thenThrow(dae);

        DataAccessException thrown = assertThrows(DataAccessException.class, () -> repository.findById(id));
        assertSame(dae, thrown);
        verify(jpaRepository).findById(id);
    }

    @Test
    void testFindByIdReturnsEmptyWhenMapperReturnsNull() {
        Long id = 55L;

        when(jpaRepository.findById(id)).thenReturn(Optional.ofNullable(null));

        Optional<Hello> result = repository.findById(id);

        assertTrue(result.isEmpty());
        verify(jpaRepository).findById(id);
    }
}