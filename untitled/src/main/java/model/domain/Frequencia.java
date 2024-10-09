package model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Frequencia {
    private int id;
    private List<LocalDate> frequencia;

    public Frequencia(){
    }

    public Frequencia(int id) {
        this.id = id;
        this.frequencia = new ArrayList<>();
    }

    public Frequencia(int id, List<LocalDate> frequencia) {
        this.id = id;
        this.frequencia = frequencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LocalDate> getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(List<LocalDate> frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Frequencia{" +
                "id=" + id +
                ", frequencia=" + frequencia +
                '}';
    }
}
