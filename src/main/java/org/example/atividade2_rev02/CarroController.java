package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CarroController {
    @FXML
    private TextField modeloField;

    @FXML
    private TextField anoField;

    @FXML
    private Button ligarButton;

    @FXML
    private Button acelerarButton;

    @FXML
    private Button frearButton;

    private final Carros carro = new Carros();

    @FXML
    public void ligarCarro() {
        carro.modelo = modeloField.getText();
        carro.ano = Integer.parseInt(anoField.getText());
        carro.ligar();
    }

    @FXML
    public void acelerarCarro() {
        carro.acelerar();
    }

    @FXML
    public void frearCarro() {
        carro.frear();
    }
}
