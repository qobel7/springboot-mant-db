package com.spring.mvcdemo.repositories.oracle;

import com.spring.mvcdemo.models.LayerEntity;
import com.spring.mvcdemo.models.oracle.Layer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LayerOracleRepository extends CrudRepository<LayerEntity,Long>  {



}
