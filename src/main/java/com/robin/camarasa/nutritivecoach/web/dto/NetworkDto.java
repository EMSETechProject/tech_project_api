package com.robin.camarasa.nutritivecoach.web.dto;

import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNBias;
import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNNetwork;
import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNNeuron;
import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNWeight;

import java.util.List;


public class NetworkDto {

    private final Long id;
    private final List<NNNeuron> neurons;
    private final List<NNBias> bias;
    private final List<NNWeight> weights;

    public NetworkDto(NNNetwork nnNetwork) {
        id = nnNetwork.getId();
        neurons = nnNetwork.getNeurons();
        bias = nnNetwork.getBias();
        weights = nnNetwork.getWeights();
    }

    public List<NNNeuron> getNeurons() {
        return neurons;
    }

    public List<NNBias> getBias() {
        return bias;
    }

    public List<NNWeight> getWeights() {
        return weights;
    }
}