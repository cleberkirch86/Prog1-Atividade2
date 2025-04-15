package org.example.atividade2_rev02;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

// Controlador da interface gráfica (FXML) para manipular dados de um Aluno
public class AlunoController {

    // Referência para os campos de texto da interface
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtCurso;

    // Label onde o status das operações será exibido
    @FXML
    private Label lblStatus;

    // Instância do objeto Aluno, usada para armazenar os dados
    private Aluno aluno;

    // Método acionado ao clicar no botão de "Cadastrar Aluno"
    @FXML
    public void cadastrarAluno() {
        // Obtém os valores digitados nos campos
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String curso = txtCurso.getText();

        // Verifica se algum campo está vazio
        if (nome.isEmpty() || matricula.isEmpty() || curso.isEmpty()) {
            lblStatus.setText("Por favor, preencha todos os campos.");
            return;
        }

        // Cria um novo objeto Aluno com os dados preenchidos
        aluno = new Aluno(nome, matricula, curso);

        // Atualiza o label com os dados do aluno cadastrado
        lblStatus.setText("Aluno cadastrado:\nNome: " + nome + "\nMatrícula: " + matricula + "\nCurso: " + curso);

        // Limpa os campos da interface após o cadastro
        limparCampos();
    }

    // Método para editar a matrícula do aluno
    @FXML
    public void editarMatricula() {
        // Verifica se o aluno foi cadastrado
        if (!verificaCadastro()) return;

        // Cria uma caixa de diálogo para inserir a nova matrícula
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editar Matrícula");
        dialog.setHeaderText("Digite a nova matrícula:");
        Optional<String> novaMatricula = dialog.showAndWait();

        // Se o usuário digitou algo e confirmou
        if (novaMatricula.isPresent()) {
            aluno.setMatricula(novaMatricula.get()); // Atualiza a matrícula
            lblStatus.setText("Matrícula alterada para: " + novaMatricula.get());
            atualizarStatus(); // Atualiza o status exibido
        }
    }

    // Método para alterar o curso do aluno
    @FXML
    public void alterarCurso() {
        // Verifica se o aluno foi cadastrado
        if (!verificaCadastro()) return;

        // Cria uma caixa de diálogo para inserir o novo curso
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Alterar Curso");
        dialog.setHeaderText("Digite o novo curso:");
        Optional<String> novoCurso = dialog.showAndWait();

        // Se o usuário digitou algo e confirmou
        if (novoCurso.isPresent()) {
            aluno.setCurso(novoCurso.get()); // Atualiza o curso
            lblStatus.setText("Curso alterado para: " + novoCurso.get());
            atualizarStatus(); // Atualiza o status exibido
        }
    }

    // Método auxiliar para verificar se o aluno já foi cadastrado
    private boolean verificaCadastro() {
        if (aluno == null) {
            lblStatus.setText("Por favor, cadastre o aluno primeiro.");
            return false;
        }
        return true;
    }

    // Atualiza o label com os dados atuais do aluno
    private void atualizarStatus() {
        lblStatus.setText("Nome: " + aluno.getNome() + "\nMatrícula: " + aluno.getMatricula() + "\nCurso: " + aluno.getCurso());
    }

    // Método para limpar os campos de texto da interface
    public void limparCampos() {
        txtNome.clear();
        txtMatricula.clear();
        txtCurso.clear();
    }
}
