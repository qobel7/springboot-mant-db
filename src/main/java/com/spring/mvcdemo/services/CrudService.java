package com.spring.mvcdemo.services;

import java.util.*;

public interface CrudService<T,ID> {

    List<T> findAll();

    List<T> findAllOracle();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);


}
