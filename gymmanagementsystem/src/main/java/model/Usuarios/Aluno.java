package model.Usuarios;

import model.Treinamento.Treinamento;

public class Aluno extends Usuario {
    private String matricula;
    private String plano;
    private Treinamento treinamento;
    private Frequencia frequencia;

    public Treinamento visualizarTreinamento(){
        System.out.println("Visualizando treinamento");
        return treinamento;
    }

    public Aluno(int id, String nome, String cpf, String email, String senha, String endereco, String telefone, String matricula, String plano) {
        super(id, nome, cpf, email, senha, endereco, telefone);
        this.matricula = matricula;
        this.plano = plano;
        this.treinamento = new Treinamento();
        this.frequencia = new Frequencia();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", plano='" + plano + '\'' +
                ", treinamento=" + treinamento +
                ", frequencia=" + frequencia +
                '}';
    }
}
