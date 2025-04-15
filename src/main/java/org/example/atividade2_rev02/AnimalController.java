package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AnimalController {

    @FXML
    private TextField txtEspecie;
    @FXML
    private TextField txtIdade;
    @FXML
    private TextField txtNome;
    @FXML
    private TextArea txtResultado;

    private Animal animal;

    @FXML
    public void cadastrarAnimal() {
        String especie = txtEspecie.getText();
        int idade = Integer.parseInt(txtIdade.getText());
        String nome = txtNome.getText();

        animal = new Animal(especie, idade, nome);
        txtResultado.setText("Animal cadastrado:\nEspécie: " + especie + "\nIdade: " + idade + "\nNome: " + nome);

        limparCampos();
    }

    @FXML
    public void emitirSom() {
        if (animal != null)
            txtResultado.setText(animal.emitirSom());
        else
            txtResultado.setText("Cadastre um animal primeiro.");
    }

    @FXML
    public void alimentar() {
        if (animal != null)
            txtResultado.setText(animal.alimentar());
        else
            txtResultado.setText("Cadastre um animal primeiro.");
    }

    @FXML
    public void mover() {
        if (animal != null)
            txtResultado.setText(animal.mover());
        else
            txtResultado.setText("Cadastre um animal primeiro.");
    }

    private void limparCampos() {
        txtEspecie.clear();
        txtIdade.clear();
        txtNome.clear();
    }
}
