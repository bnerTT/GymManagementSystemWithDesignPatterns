package model.Usuarios;

import java.util.ArrayList;

public class Gerente extends Usuario {
    private String departamento;

    public void cadastrarAluno(Aluno aluno, Instrutor instrutor){
        System.out.println(aluno + " associado a " + instrutor);
    }

    public void gerenciarAlunos(ArrayList<Aluno> alunos){
        System.out.println("Alunos gerenciados");
    }

    public Gerente(int id, String nome, String cpf, String email, String senha, String endereco, String telefone, String departamento) {
        super(id, nome, cpf, email, senha, endereco, telefone);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "departamento='" + departamento + '\'' +
                '}';
    }
}
