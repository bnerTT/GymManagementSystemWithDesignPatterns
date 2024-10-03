package model.Usuarios;

public class Aluno extends Usuario {
    private String matricula;
    private String plano;
    private Treinamento treinamento;
    private Frequencia frequencia;

    public Treinamento visualizarTreinamento(){
        System.out.println("Visualizando treinamento");
        return treinamento;
    }

    public Aluno(String nome, String email, String senha, String matricula, String plano, Treinamento treinamento, Frequencia frequencia) {
        super(nome, email, senha);
        this.matricula = matricula;
        this.plano = plano;
        this.treinamento = treinamento;
        this.frequencia = frequencia;
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
                ", usuario=" + super.toString() +
                '}';
    }

}
