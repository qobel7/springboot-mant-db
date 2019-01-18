package com.spring.mvcdemo.repositories.oracle;

import com.spring.mvcdemo.models.oracle.Menu;
import com.spring.mvcdemo.models.MenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuOracleRepository extends CrudRepository<MenuEntity,Long> {

    MenuEntity findByName(String name);

    MenuEntity findByNameAndParentID(String name, Long ParentID);


}
