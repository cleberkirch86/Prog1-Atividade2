package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextField;

import java.util.Optional;

// Controlador JavaFX para a tela de Times de Futebol
public class TimeFutebolController {

    // Campos de entrada de dados (nome, cidade e número de títulos)
    @FXML
    private TextField txtNome, txtCidade, txtTitulos;

    // Label onde o resultado ou informações serão exibidas
    @FXML
    private Label lblResultado;

    // Variável interna para armazenar o número de títulos do time
    private int titulos;

    // Exibe as informações do time na tela (nome, cidade, títulos)
    @FXML
    private void exibirInformacoes() {
        // Lê os valores dos campos de texto
        String nome = txtNome.getText();
        String cidade = txtCidade.getText();
        titulos = Integer.parseInt(txtTitulos.getText()); // Converte texto para inteiro

        // Atualiza o label com as informações do time
        lblResultado.setText("Time: " + nome + "\nCidade: " + cidade + "\nTítulos: " + titulos);
    }

    // Simula o registro de uma vitória importante (incrementa títulos)
    @FXML
    private void registrarVitoriaImportante() {
        titulos++; // Incrementa o número de títulos
        txtTitulos.setText(String.valueOf(titulos)); // Atualiza o campo de texto
        lblResultado.setText("🎉 Vitória registrada! Agora o time tem " + titulos + " título(s)!");
    }

    // Permite desafiar outro time, usando caixas de diálogo para entrada
    @FXML
    private void desafiarOutroTime() {
        // Primeiro diálogo: nome do time adversário
        TextInputDialog dialog1 = new TextInputDialog();
        dialog1.setTitle("Desafio de Time");
        dialog1.setHeaderText("Desafiar Outro Time");
        dialog1.setContentText("Nome do time adversário:");
        Optional<String> timeAdversario = dialog1.showAndWait();

        // Segundo diálogo: local do jogo
        TextInputDialog dialog2 = new TextInputDialog();
        dialog2.setTitle("Local do Jogo");
        dialog2.setHeaderText("Informe o Estádio");
        dialog2.setContentText("Local do jogo:");
        Optional<String> local = dialog2.showAndWait();

        // Se ambos os dados forem preenchidos, exibe a mensagem de desafio
        if (timeAdversario.isPresent() && local.isPresent()) {
            lblResultado.setText("⚽ " + txtNome.getText() + " desafiou " + timeAdversario.get() + " no estádio " + local.get() + "!");
        }
    }

    // Limpa todos os campos e o label de resultado
    @FXML
    private void limparCampos() {
        txtNome.clear();
        txtCidade.clear();
        txtTitulos.clear();
        lblResultado.setText("");
    }
}
