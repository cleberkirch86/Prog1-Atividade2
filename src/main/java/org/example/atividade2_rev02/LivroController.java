package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LivroController {

    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtPaginas;

    public void exibirInformacoes() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String paginas = txtPaginas.getText();

        showAlert("Informações do Livro", "Título: " + titulo + "\nAutor: " + autor + "\nPáginas: " + paginas);
    }

    public void folhearPagina() {
        showAlert("Folhear", "Você folheou algumas páginas do livro \"" + txtTitulo.getText() + "\".");
    }

    public void emprestarLivro() {
        showAlert("Empréstimo", "O livro \"" + txtTitulo.getText() + "\" foi emprestado.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
