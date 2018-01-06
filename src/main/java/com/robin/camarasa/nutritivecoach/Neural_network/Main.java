package com.robin.camarasa.nutritivecoach.Neural_network;

import com.robin.camarasa.nutritivecoach.dao.NNBiasDao;

public class Main {
    public static void main(String[] args) {
        String result_weights = new String();
        String result_bias = new String();
        String result_neuron = new String();
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 8 ; j++) {
                for (int k = 0 ; k < 8 ; k++) {
                    if (i < 2 || (i == 2 && k == 1)) {
                        if (i == 0) {
                            if (j == 0) {
                                result_weights =  result_weights.concat("INSERT INTO NNWEIGHT (id, value) VALUES (" + k + ", 0.5);\n");
                            } else {
                                result_weights =  result_weights.concat("INSERT INTO NNWEIGHT (id, value) VALUES (" + j + k + ", 0.5);\n");
                            }
                        } else {
                            result_weights =  result_weights.concat("INSERT INTO NNWEIGHT (id, value) VALUES (" + i + j + k + ", 0.5);\n");
                        }
                    }
                }
                if ((i >= 1 && i != 3) || (i == 3 && j == 0)) {
                    result_bias = result_bias.concat("INSERT INTO NNBIAS (id, value) VALUES (" + i + j + ", -2);\n");
                }
                if (i < 3 || (i == 3 && j == 0)) {
                    if (i == 0) {
                        result_neuron = result_neuron.concat("INSERT INTO NNNEURON (id, value) VALUES (" + j + ", 0.5);\n");
                    } else {
                        result_neuron = result_neuron.concat("INSERT INTO NNNEURON (id, value) VALUES (" + i + j + ", 0.5);\n");
                    }
                }

            }
        }
        System.out.println(result_weights + result_bias + result_neuron);
    }
}
