package com.spring.mvcdemo.repositories.postgre;

import com.spring.mvcdemo.models.LayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LayerRepository extends CrudRepository<LayerEntity,Long>  {



}
