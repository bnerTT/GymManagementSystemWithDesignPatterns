package model.domain;

public class Aluno extends Usuario{
    private static int alunosMatriculados = 0;
    private String matricula;
    private String plano;
    private Instrutor instrutor;
    private Treinamento treinamento;
    private Frequencia frequencia;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, String email, String senha, String telefone, String endereco, String matricula, String plano) {
        super(nome, cpf, email, senha, telefone, endereco);
        this.matricula = matricula;
        this.plano = plano;
    }

    public Aluno(int id, String nome, String cpf, String email, String senha, String telefone, String endereco, String matricula, String plano, Instrutor instrutor, Treinamento treinamento, Frequencia frequencia) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        this.matricula = matricula;
        this.plano = plano;
        this.instrutor = instrutor;
        this.treinamento = treinamento;
        this.frequencia = frequencia;
    }

    public Aluno(int id, String nome, String cpf, String email, String senha, String telefone, String endereco, String matricula, String plano) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        this.matricula = matricula;
        this.plano = plano;
        this.instrutor = null;
        this.treinamento = new Treinamento();
        this.frequencia = new Frequencia();
    }

    public Aluno(int id, String nome, String cpf, String email, String senha, String telefone, String endereco, String matricula, String plano, Instrutor instrutor) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        this.matricula = matricula;
        this.plano = plano;
        this.instrutor = instrutor;
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

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
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
}
