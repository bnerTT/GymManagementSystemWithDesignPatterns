package controller;

import model.dao.TreinamentoDAO;
import model.dao.TreinoDiaDAO;
import model.domain.Aluno;
import model.domain.Treinamento;
import model.domain.TreinoDia;

import java.sql.SQLException;
import java.util.List;

public class TreinamentoController {
    TreinamentoDAO treinamentoDAO = new TreinamentoDAO();
    TreinoDiaDAO treinoDiaDao = new TreinoDiaDAO();

    public Treinamento criarTreinamento() throws SQLException {
        Treinamento treinamento = new Treinamento();
        treinamentoDAO.inserirTreinamento(treinamento);
        return treinamento;
    }

    public void removerTreinoDia(Treinamento treinamento) throws SQLException {
        List<TreinoDia> treinosDias = treinoDiaDao.buscarTreinoDiasPorTreinamentoId(treinamento.getId());
        for(TreinoDia treinoDia : treinosDias) {
            treinoDiaDao.excluirTreinoPorTreinoDia(treinoDia.getId());
        }
        treinoDiaDao.excluirTreinoDiaPorTreinamento(treinamento.getId());
    }

    public void removerTreinamento(Treinamento treinamento) throws SQLException {
        treinamentoDAO.excluirTreinamento(treinamento.getId());
    }

    public void listarExerciciosPorDia(Aluno aluno) throws SQLException {
        // Buscar o treinamento pelo ID
        Treinamento treinamento = treinamentoDAO.buscarTreinamentoPorId(aluno.getTreinamento().getId());

        if (treinamento != null) {
            System.out.println("Treinamento: " + treinamento.getTipo());
            System.out.println("Período: " + treinamento.getDataInicio() + " - " + treinamento.getDataFim());

            // Percorrer os dias de treino
            for (TreinoDia treinoDia : treinamento.getExerciciosDias()) {
                System.out.println("\nDia da semana: " + treinoDia.getDiaSemana());

                // Listar as atividades/exercícios do dia
                List<String> atividades = treinoDia.getAtividades();
                if (atividades.isEmpty()) {
                    System.out.println("Nenhum exercício para este dia.");
                } else {
                    for (int i = 0; i < atividades.size(); i++) {
                        System.out.println((i + 1) + ". " + atividades.get(i));
                    }
                }
            }
        } else {
            System.out.println("Treinamento não encontrado.");
        }
    }
}
