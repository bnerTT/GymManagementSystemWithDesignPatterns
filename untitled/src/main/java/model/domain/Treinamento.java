package model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Treinamento {
    private int id;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<TreinoDia> exerciciosDias;

    public Treinamento() {
    }

    public Treinamento(int id, String tipo, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.exerciciosDias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public List<TreinoDia> getExerciciosDias() {
        return exerciciosDias;
    }

    public void setExerciciosDias(List<TreinoDia> exerciciosDias) {
        this.exerciciosDias = exerciciosDias;
    }

    @Override
    public String toString() {
        return "Treinamento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", exerciciosDias=" + exerciciosDias +
                '}';
    }
}
