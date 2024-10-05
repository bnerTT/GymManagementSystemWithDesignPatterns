package entity.Usuarios;

import entity.Treinamento.Treinamento;
import jakarta.persistence.*;


@Entity
public class Aluno extends Usuario {

    private String matricula;

    private String plano;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "treinamento_id", referencedColumnName = "id")
    private Treinamento treinamento;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "frequencia_id", referencedColumnName = "id")
    private Frequencia frequencia;

    public Treinamento visualizarTreinamento(){
        System.out.println("Visualizando treinamento");
        return treinamento;
    }

    public Aluno(){
    }

    public Aluno(int id, String nome, String cpf, String email, String senha, String endereco, String telefone, String matricula, String plano) {
        super(id, nome, cpf, email, senha, endereco, telefone);
        this.matricula = matricula;
        this.plano = plano;
        this.instrutor = null;
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

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
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
