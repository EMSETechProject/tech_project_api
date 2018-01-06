package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.Neural_network.NNBias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNNeuron extends JpaRepository<NNNeuron, Long> {
}