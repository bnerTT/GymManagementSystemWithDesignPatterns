package controller;

import model.dao.AlunoDAO;
import model.domain.Treinamento;
import model.domain.usuarios.Aluno;
import model.domain.usuarios.Instrutor;

import java.sql.SQLException;

public class AlunoController {
    AlunoDAO alunoDAO = new AlunoDAO();

    public Aluno buscarAlunoPorNome(String nome) throws SQLException {
        return alunoDAO.buscarPorNome(nome);
    }

    public Aluno buscarAlunoPorEmail(String email) throws SQLException {
        return alunoDAO.buscarAlunoPorEmail(email);
    }

    public void associarAlunoTreino(Aluno aluno, Treinamento treinamento) throws SQLException {
        aluno.setTreinamento(treinamento);
        alunoDAO.adicionarTreinamento(aluno);
    }

    public void associarAlunoInstrutor(Aluno aluno, Instrutor instrutor) throws SQLException {
        aluno.setInstrutor(instrutor);
    }

    public void cadastrarAluno(Aluno aluno) throws SQLException {
        alunoDAO.salvar(aluno);
    }

    public void removerAluno(Aluno aluno) throws SQLException {
        if(aluno.getTreinamento() != null){
            TreinamentoController treinamentoController = new TreinamentoController();
            treinamentoController.removerTreinoDia(aluno.getTreinamento());
            treinamentoController.removerTreinamento(aluno.getTreinamento());
        }
        alunoDAO.deletar(aluno.getId());
    }

    public void editar(Aluno aluno, Aluno alunoEditado) throws SQLException {
        alunoDAO.editarAluno(aluno.getId(), alunoEditado);
    }
}
