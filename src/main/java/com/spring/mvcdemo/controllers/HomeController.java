package com.spring.mvcdemo.controllers;


import com.google.gson.Gson;
import com.spring.mvcdemo.repositories.oracle.LayerOracleRepository;
import com.spring.mvcdemo.services.LayerService;
import com.spring.mvcdemo.services.MenuService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private MenuService menuService;
    private LayerService layerService;
    private LayerService layerOracleService;
    private LayerOracleRepository layerOracleRepository;

    public HomeController(MenuService menuService, @Qualifier("layerServiceImp") LayerService layerService,
                          LayerOracleRepository layerOracleRepository) {
        this.menuService = menuService;
        this.layerService = layerService;
        this.layerOracleRepository =layerOracleRepository;
    }

    @RequestMapping(name = "index",path = "/")
    public String index(Model model){
        /*model.addAttribute("welcome",menuService.findAll());
        model.addAttribute("welcome",layerService.findAll());*/
        return new Gson().toJson(layerService.findAll())+new Gson().toJson(layerService.findAllOracle()) ;
    }

    @RequestMapping(value = "/getString", method = RequestMethod.GET, produces = "application/json")
    public String test(Model model){

        return "{  \"response\" : \"your string value\" }";
    }

}
