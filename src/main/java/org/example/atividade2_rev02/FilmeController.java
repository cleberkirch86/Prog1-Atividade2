package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FilmeController {

    @FXML
    private TextField txtTitulo, txtGenero, txtDuracao;

    @FXML
    private TextArea txtResultado;

    private Filme filme;

    public void cadastrarFilme() {
        String titulo = txtTitulo.getText();
        String genero = txtGenero.getText();
        int duracao = Integer.parseInt(txtDuracao.getText());

        filme = new Filme(titulo, genero, duracao);
        txtResultado.setText("Filme cadastrado com sucesso!\n\n" + filme.exibirCadastro());
        limparCampos();
    }

    public void reproduzirFilme() {
        if (filme != null) {
            txtResultado.setText(filme.reproduzir());
        } else {
            txtResultado.setText("Cadastre um filme primeiro!");
        }
    }

    public void pausarFilme() {
        if (filme != null) {
            txtResultado.setText(filme.pausar());
        } else {
            txtResultado.setText("Cadastre um filme primeiro!");
        }
    }

    private void limparCampos() {
        txtTitulo.clear();
        txtGenero.clear();
        txtDuracao.clear();
    }
}
