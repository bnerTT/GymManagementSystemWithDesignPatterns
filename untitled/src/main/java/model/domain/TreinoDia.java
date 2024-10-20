package model.domain;

import java.util.ArrayList;
import java.util.List;

public class TreinoDia {
    private int id;
    private String diaSemana;
    private int treinamento;
    private List<String> atividades;

    public TreinoDia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public List<String> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<String> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        return "TreinoDia{" +
                "id=" + id +
                ", diaSemana='" + diaSemana + '\'' +
                ", treinamento=" + treinamento +
                ", atividades=" + atividades +
                '}';
    }
}
