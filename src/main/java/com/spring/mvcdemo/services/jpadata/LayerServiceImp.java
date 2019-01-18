package com.spring.mvcdemo.services.jpadata;

import com.spring.mvcdemo.models.LayerEntity;
import com.spring.mvcdemo.models.oracle.Layer;
import com.spring.mvcdemo.repositories.oracle.LayerOracleRepository;
import com.spring.mvcdemo.repositories.postgre.LayerRepository;
import com.spring.mvcdemo.services.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional("posgreTransactionManager")
public class LayerServiceImp implements LayerService<LayerEntity> {

    private LayerRepository layerRepository;
    private LayerOracleRepository layerOracleRepository;


    @Autowired
    public LayerServiceImp(LayerRepository layerRepository , LayerOracleRepository layerOracleRepository) {
        this.layerRepository = layerRepository;
        this.layerOracleRepository = layerOracleRepository;
    }


    @Override
    public List<LayerEntity> findAll() {
        List<LayerEntity> layers = new ArrayList<>();

        layerRepository.findAll().forEach(layers::add);
        return layers;
    }

    @Override
    @Transactional("oracleTransactionManager")
    public List<LayerEntity> findAllOracle() {
        List<LayerEntity> layers = new ArrayList<>();
        layerOracleRepository.findAll().forEach(layers::add);
        return layers;
    }

    @Override
    public LayerEntity findById(Long aLong) {
        return null;
    }

    @Override
    public LayerEntity save(LayerEntity object) {
        return null;
    }

    @Override
    public void delete(LayerEntity object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
