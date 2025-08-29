package com.neo.learn.application;

import java.io.Serializable;
import java.util.Optional;

public interface Repository<T, K extends Serializable> {

	Optional<T> findById(K id);

}
