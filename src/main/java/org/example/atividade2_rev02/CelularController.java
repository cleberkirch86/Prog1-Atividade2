package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.Random;

public class CelularController {

    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtModelo;
    @FXML
    private Label lblStatus;

    private Celular celular;

    @FXML
    public void cadastrarCelular() {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();

        if (marca.isEmpty() || modelo.isEmpty()) {
            lblStatus.setText("Por favor, preencha todos os campos.");
            return;
        }

        celular = new Celular(marca, modelo);
        lblStatus.setText("Celular cadastrado:\nMarca: " + marca + "\nModelo: " + modelo + "\nBateria: " + celular.getBateria() + "%");
    }

    @FXML
    public void ligar() {
        if (!verificaCadastro()) return;

        celular.ligar();
        atualizarStatus();
    }

    @FXML
    public void carregarBateria() {
        if (!verificaCadastro()) return;

        celular.carregarBateria();
        atualizarStatus();
    }

    @FXML
    public void enviarMensagem() {
        if (!verificaCadastro()) return;

        TextInputDialog numeroDialog = new TextInputDialog();
        numeroDialog.setTitle("Enviar Mensagem");
        numeroDialog.setHeaderText("Digite o número para envio:");
        Optional<String> numero = numeroDialog.showAndWait();

        if (numero.isPresent()) {
            TextInputDialog mensagemDialog = new TextInputDialog();
            mensagemDialog.setTitle("Mensagem");
            mensagemDialog.setHeaderText("Digite a mensagem:");
            Optional<String> mensagem = mensagemDialog.showAndWait();

            if (mensagem.isPresent()) {
                celular.enviarMensagem(numero.get(), mensagem.get());
                lblStatus.setText("Mensagem enviada para " + numero.get() + ": " + mensagem.get());
                atualizarStatus();
            }
        }
    }

    private boolean verificaCadastro() {
        if (celular == null) {
            lblStatus.setText("Por favor, cadastre o celular primeiro.");
            return false;
        }
        return true;
    }

    private void atualizarStatus() {
        lblStatus.setText("Marca: " + celular.getMarca() + "\nModelo: " + celular.getModelo() + "\nBateria: " + celular.getBateria() + "%");
    }

    public void limparCampos() {
        txtModelo.clear();
        txtMarca.clear();

    }
}
