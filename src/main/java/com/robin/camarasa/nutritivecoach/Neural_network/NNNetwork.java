package com.robin.camarasa.nutritivecoach.Neural_network;

import com.robin.camarasa.nutritivecoach.model.Recipe;
import com.robin.camarasa.nutritivecoach.model.User;
import com.robin.camarasa.nutritivecoach.model.Weight;
import com.robin.camarasa.nutritivecoach.problem_solving.csp.db.RecipeCSPDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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

    public void modifyWeight(int i, Float value) {
        weights.get(i).setValue(value);
    }

    public void modifyBias(int i, Float value) {
        bias.get(i).setValue(value);
    }

    public void computeNeuron(int j) {
        Float neuronvalue = 0f;
        int jprime = j - 8;
        for (int i = 0 ; i < 8 ; i ++) {
            neuronvalue += weights.get(8 * jprime + i).getValue() * neurons.get(new Double(Math.floor(jprime / 8)).intValue() * 8 + i).getValue();
        }
        neuronvalue += bias.get(jprime).getValue();
        neurons.get(j).setValue(neuronvalue);
    }

    public void computeNetwork() {
        for (int i = 8 ; i < neurons.size() ; i++) {
            computeNeuron(i);
        }
    }

    public Float cost(Float rate) {
        computeNetwork();
        return (rate - neurons.get(neurons.size() - 1).getValue()) * (rate - neurons.get(neurons.size() - 1).getValue());
    }

    public Float gradWeight(int i, Float costinit , Float rate) {
        Float tmp = weights.get(i).getValue();
        weights.get(i).setValue(tmp + 0.05f);
        Float cost = cost(rate);
        weights.get(i).setValue(tmp);
        return (cost - costinit)/0.05f;
    }

    public Float gradBias(int i, Float costinit, Float rate) {
        Float tmp = bias.get(i).getValue();
        bias.get(i).setValue(tmp + 0.05f);
        Float cost = cost(rate);
        bias.get(i).setValue(tmp);
        return (cost - costinit)/0.05f;
    }

    public void learn(User user, RecipeCSPDto recipeCSPDto, Float rate) {
        neurons.get(0).setValue(user.getPhysicalData().getAge().floatValue()/100f);
        neurons.get(1).setValue(user.getPhysicalData().getSize().floatValue()/2.2f);
        neurons.get(2).setValue(user.getPhysicalData().getWeight()/150f);
        neurons.get(3).setValue(recipeCSPDto.getCalories());
        neurons.get(4).setValue(recipeCSPDto.getFibres());
        neurons.get(5).setValue(recipeCSPDto.getProteines());
        neurons.get(6).setValue(recipeCSPDto.getLipides());
        neurons.get(7).setValue(recipeCSPDto.getGlucides());

        List<Float> gradw = new ArrayList<>();
        List<Float> gradb = new ArrayList<>();

        Float costinit = cost(rate);

        for (int i = 0 ; i < weights.size() ; i++) {
            gradw.add(gradWeight(i, costinit, rate));
        }

        for (int i = 0 ; i < bias.size() ; i++) {
            gradb.add(gradBias(i, costinit, rate));
        }

        for (int i = 0 ; i < bias.size() ; i++) {
            Float tmp = bias.get(i).getValue();
            bias.get(i).setValue(tmp + gradb.get(i));
        }

        for (int i = 0 ; i < weights.size() ; i++) {
            Float tmp = weights.get(i).getValue();
            weights.get(i).setValue(tmp + gradw.get(i));
        }
    }
}
