package com.robin.camarasa.nutritivecoach.dao;
import com.robin.camarasa.nutritivecoach.Neural_network.NNWeight;
import com.robin.camarasa.nutritivecoach.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNWeightDao extends JpaRepository<NNWeight, Long> {
}