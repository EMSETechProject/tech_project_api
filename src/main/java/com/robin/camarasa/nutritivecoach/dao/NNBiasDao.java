package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNBias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNBiasDao extends JpaRepository<NNBias, Long> {
}