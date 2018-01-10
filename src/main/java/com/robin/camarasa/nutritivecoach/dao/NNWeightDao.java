package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.IA.Neural_network.NNWeight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNWeightDao extends JpaRepository<NNWeight, Long> {
}