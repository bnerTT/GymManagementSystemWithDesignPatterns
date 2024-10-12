package controller;

import model.dao.TreinamentoDAO;
import model.dao.TreinoDiaDAO;
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
}
