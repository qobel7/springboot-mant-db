package com.spring.mvcdemo.repositories.postgre;

import com.spring.mvcdemo.models.MenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends CrudRepository<MenuEntity,Long> {

    MenuEntity findByName(String name);

    MenuEntity findByNameAndParentID(String name, Long ParentID);


}
