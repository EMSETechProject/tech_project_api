package com.robin.camarasa.nutritivecoach.web.Controller;

import com.robin.camarasa.nutritivecoach.Neural_network.NNNetwork;
import com.robin.camarasa.nutritivecoach.dao.*;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.UserCSPDto;
import com.robin.camarasa.nutritivecoach.web.dto.NetworkDto;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/tests")
@Transactional
public class TestController {

    private final NNBiasDao nnBiasDao;
    private final NNNetworkDao nnNetworkDao;
    private final NNWeightDao nnWeightDao;
    private final NNNeuronDao nnNeuronDao;

    public TestController(NNBiasDao nnBiasDao, NNNetworkDao nnNetworkDao, NNWeightDao nnWeightDao, NNNeuronDao nnNeuronDao) {
        this.nnBiasDao = nnBiasDao;
        this.nnNetworkDao = nnNetworkDao;
        this.nnWeightDao = nnWeightDao;
        this.nnNeuronDao = nnNeuronDao;
    }

    @GetMapping(value = "/makeNetwork")
    public NetworkDto testUser() {
        return new NetworkDto(new NNNetwork(1l, nnWeightDao.findAll(), nnBiasDao.findAll(), nnNeuronDao.findAll()));
    }
}