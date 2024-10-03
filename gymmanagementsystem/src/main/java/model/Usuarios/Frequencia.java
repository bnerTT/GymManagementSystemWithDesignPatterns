package model.Usuarios;

import java.time.LocalDate;

public class Frequencia {
    private LocalDate hora;
    private LocalTime data;
    private List<Frequencia> registroFrequencia;

    public void registarFrequencia(){
        System.out.println("Frequencia registrada");
    }
}
