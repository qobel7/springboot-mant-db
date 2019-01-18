package com.spring.mvcdemo.services.jpadata;

import com.spring.mvcdemo.models.oracle.Layer;
import com.spring.mvcdemo.repositories.oracle.LayerOracleRepository;
import com.spring.mvcdemo.services.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional("oracleTransactionManager")
public class LayerOracleServiceImp {


}
