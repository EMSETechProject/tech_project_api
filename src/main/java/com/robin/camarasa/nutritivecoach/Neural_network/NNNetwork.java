package com.robin.camarasa.nutritivecoach.Neural_network;

import com.robin.camarasa.nutritivecoach.model.Weight;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@SuppressWarnings("serial")
public class NNNetwork {
    @Id
    private Long id;

    @OneToMany
    private List<NNWeight> weights;

    @OneToMany
    private List<NNBias> bias;

    @OneToMany
    private List<NNNeuron> neurons;

    public NNNetwork() {
    }

    public NNNetwork(Long id, List<NNWeight> weights, List<NNBias> bias, List<NNNeuron> neurons) {
        this.id = id;
        this.weights = weights;
        this.bias = bias;
        this.neurons = neurons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NNWeight> getWeights() {
        return weights;
    }

    public void setWeights(List<NNWeight> weights) {
        this.weights = weights;
    }

    public List<NNBias> getBias() {
        return bias;
    }

    public void setBias(List<NNBias> bias) {
        this.bias = bias;
    }

    public List<NNNeuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<NNNeuron> neurons) {
        this.neurons = neurons;
    }
}
