package model.Treinamento;

public class TreinoDia {
    private int id;
    private String diaSemana;
    private List<String> atividades;

    private void adicionarAtividade(String atividade){
        System.out.println(atividade + " adicionada");
    }

    private void removerAtividade(String atividade){
        System.out.println(atividade + " removida");
    }
}
