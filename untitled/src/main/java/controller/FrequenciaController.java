package controller;

import model.dao.FrequenciaDAO;
import model.domain.Aluno;
import model.domain.Frequencia;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class FrequenciaController {
    FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

    public void inserirFrequencia(Frequencia frequencia) throws SQLException {
        LocalDate data = LocalDate.now();
        frequencia.getFrequencia().add(data);
    }

    public Frequencia criarNovaFrequencia() throws SQLException {
        Frequencia frequencia = new Frequencia();
        frequenciaDAO.salvar(frequencia);
        return frequencia;
    }

    public void listarFrequencia(Aluno aluno) throws SQLException {
        Frequencia frequencia = frequenciaDAO.buscarFrequenciasPorId(aluno.getFrequencia().getId());
        for(LocalDate dia : frequencia.getFrequencia()){
            System.out.println(dia);
        }
    }

    /*public void listarFrequencias() throws SQLException {
        List<Frequencia> frequencias = frequenciaDAO.buscarTodasFrequencias();

        if (frequencias.isEmpty()) {
            System.out.println("Nenhuma frequência encontrada.");
        } else {
            for (Frequencia frequencia : frequencias) {
                System.out.println("Frequência ID: " + frequencia.getId());
                System.out.println("Datas: ");
                for (LocalDate data : frequencia.getFrequencia()) {
                    System.out.println("- " + data);
                }
                System.out.println();
            }
        }
    }*/
}
