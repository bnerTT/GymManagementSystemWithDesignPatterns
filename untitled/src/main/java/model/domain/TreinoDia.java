package model.domain;

import java.util.ArrayList;
import java.util.List;

public class TreinoDia {
    private int id;
    private String diaSemana;
    private Treinamento treinamento;
    private List<String> atividades;

    public TreinoDia() {
    }

    public TreinoDia(int id, String diaSemana, Treinamento treinamento) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.treinamento = treinamento;
        this.atividades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
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
