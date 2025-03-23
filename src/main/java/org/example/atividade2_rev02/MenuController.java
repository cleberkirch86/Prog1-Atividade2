package org.example.atividade2_rev02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

    private Carros carro = new Carros(); // Instancia a classe Carros

    @FXML
    public void acelerar(ActionEvent event) {
        carro.acelerar();
    }

    @FXML
    public void frear(ActionEvent event) {
        carro.frear();
    }

    @FXML
    public void sair(ActionEvent event) {
        System.exit(0);
    }
}