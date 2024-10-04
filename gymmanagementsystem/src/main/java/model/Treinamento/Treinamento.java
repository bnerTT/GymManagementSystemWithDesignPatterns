package model.Treinamento;


import java.util.ArrayList;
import java.util.Date;

public class Treinamento {
    private int id;
    private String tipo;
    private Date dataInicio;
    private Date dataFinal;
    private ArrayList<TreinoDia> exerciciosDias;

    private void adicionarTreinoDia(TreinoDia treinoDia){
        System.out.println(treinoDia + " adicionado");
    }

    private void removerTreinoDia(TreinoDia treinoDia){
        System.out.println(treinoDia + " removido");
    }

    public Treinamento(){
    }

    public Treinamento(int id, String tipo, Date dataInicio, Date dataFinal) {
        this.id = id;
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.exerciciosDias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public ArrayList<TreinoDia> getExerciciosDias() {
        return exerciciosDias;
    }

    public void setExerciciosDias(ArrayList<TreinoDia> exerciciosDias) {
        this.exerciciosDias = exerciciosDias;
    }

    @Override
    public String toString() {
        return "Treinamento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", exerciciosDias=" + exerciciosDias +
                '}';
    }
}
