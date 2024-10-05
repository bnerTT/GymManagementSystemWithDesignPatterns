package entity.Usuarios;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Frequencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    private ArrayList<LocalDate> frequencia;

    public void registarFrequencia(){
        System.out.println("Frequencia registrada");
    }

    public Frequencia() {
        this.frequencia = new ArrayList<>();
    }

    public ArrayList<LocalDate> getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(ArrayList<LocalDate> frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Frequencia{" +
                "frequencia=" + frequencia +
                '}';
    }
}
