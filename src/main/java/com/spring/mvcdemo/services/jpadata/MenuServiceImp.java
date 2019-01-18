package com.spring.mvcdemo.services.jpadata;


import com.spring.mvcdemo.models.LanguageEntity;
import com.spring.mvcdemo.models.MenuEntity;
import com.spring.mvcdemo.models.oracle.Menu;
import com.spring.mvcdemo.repositories.postgre.MenuRepository;
import com.spring.mvcdemo.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional("posgreTransactionManager")
public class MenuServiceImp implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public MenuServiceImp(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public List<MenuEntity> findAll() {
        List<MenuEntity> menuList =  new ArrayList<>();
        menuRepository.findAll().forEach(menuList::add);
        return menuList;
    }

    @Override
    public List<MenuEntity> findAllOracle() {
        return null;
    }

    @Override
    public MenuEntity findById(Long aLong) {


        return null;
    }

    @Override
    public MenuEntity save(MenuEntity object) {
        MenuEntity menu = new MenuEntity();
        LanguageEntity language = new LanguageEntity();
        language.setKey("Menu1");
        language.setValue("Menu1");
        language.setType("tr");
        LanguageEntity languageen = new LanguageEntity();
        language.setKey("Menu1");
        language.setValue("menu2");
        language.setType("en");
        List<LanguageEntity>languages =new ArrayList<>();
        languages.add(language);
        languages.add(languageen);
/*
        menu.setLanguage(languages);
*/
        menu.setName("Menu1");
        menu.setUrl("queryaddress");
        menu.setParentID(0);
        menuRepository.save(menu);
        return menu;
    }

    @Override
    public void delete(MenuEntity object) {

    }





    @Override
    public void deleteById(Long aLong) {

    }
}
