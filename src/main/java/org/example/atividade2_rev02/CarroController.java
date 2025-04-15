package org.example.atividade2_rev02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


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

    @FXML
    private TextField mensagemField;

    private final Carros carro = new Carros();


    @FXML
    public void ligarCarro() {
        try {
            // Mantém a lógica atual
            carro.modelo = modeloField.getText();
            carro.ano = Integer.parseInt(anoField.getText());
            carro.ligar();

            String mensagem = "O carro do modelo " + carro.modelo + " e do ano " + carro.ano + " está ligado!";
            mensagemField.setText(mensagem);

            // Adiciona o som do Opala
            String caminhoAudio = "src/main/resources/sounds/opala.mp3";
            File arquivoAudio = new File(caminhoAudio);
            if (arquivoAudio.exists()) {
                Media media = new Media(arquivoAudio.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            } else {
                System.err.println("⚠ Arquivo de som não encontrado: " + caminhoAudio);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mensagemField.setText("Erro ao ligar o carro. Verifique os dados!");
        }
    }

    @FXML
    public void acelerarCarro() {
        carro.acelerar();
    }

    @FXML
    public void frearCarro() {
        carro.frear();
    }


    @FXML
    public void fechar(ActionEvent event) {
        // Remove a view Carro do seu parent (StackPane)
        Node source = (Node) event.getSource();
        Node parent = source.getParent();
        if (parent != null && parent.getParent() instanceof javafx.scene.layout.StackPane) {
            javafx.scene.layout.StackPane stackPane = (javafx.scene.layout.StackPane) parent.getParent();
            stackPane.getChildren().remove(parent);
        }
    }
}
