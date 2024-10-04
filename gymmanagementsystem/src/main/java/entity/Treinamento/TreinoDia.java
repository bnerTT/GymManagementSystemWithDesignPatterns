package entity.Treinamento;

import java.util.ArrayList;

public class TreinoDia {
    private int id;
    private String diaSemana;
    private ArrayList<String> atividades;

    private void adicionarAtividade(String atividade){
        System.out.println(atividade + " adicionada");
    }

    private void removerAtividade(String atividade){
        System.out.println(atividade + " removida");
    }

    public TreinoDia(String diaSemana, int id) {
        this.diaSemana = diaSemana;
        this.id = id;
        this.atividades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public ArrayList<String> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<String> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        return "TreinoDia{" +
                "id=" + id +
                ", diaSemana='" + diaSemana + '\'' +
                ", atividades=" + atividades +
                '}';
    }
}
