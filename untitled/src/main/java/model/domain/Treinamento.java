package model.domain;

import model.domain.usuarios.Aluno;

import java.time.LocalDate;
import java.util.List;

public class Treinamento {
    private int id;
    private Aluno aluno;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<TreinoDia> exerciciosDias;

    public Treinamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
