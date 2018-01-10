package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNNeuron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNNeuronDao extends JpaRepository<NNNeuron, Long> {
}