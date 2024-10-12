package controller;

import model.dao.AlunoDAO;
import model.domain.Aluno;
import model.domain.Instrutor;

import java.sql.SQLException;

public class AlunoController {
    AlunoDAO alunoDAO = new AlunoDAO();

    public Aluno buscarAlunoPorNome(String nome) throws SQLException {
        return alunoDAO.buscarPorNome(nome);
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
}
