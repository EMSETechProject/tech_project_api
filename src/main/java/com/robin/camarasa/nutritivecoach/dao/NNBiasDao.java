package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.Neural_network.NNBias;
import com.robin.camarasa.nutritivecoach.Neural_network.NNWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNBiasDao extends JpaRepository<NNBias, Long> {
}