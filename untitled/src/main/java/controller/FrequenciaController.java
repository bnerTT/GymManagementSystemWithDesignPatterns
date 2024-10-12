package controller;

import model.dao.FrequenciaDAO;
import model.domain.Frequencia;

import java.sql.SQLException;

public class FrequenciaController {
    FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

    public Frequencia criarNovaFrequencia() throws SQLException {
        Frequencia frequencia = new Frequencia();
        frequenciaDAO.salvar(frequencia);
        return frequencia;
    }
}
