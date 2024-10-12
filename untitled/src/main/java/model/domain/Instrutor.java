package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Usuario {
    private List<Aluno> alunos;

    public Instrutor(){
    }

    public Instrutor(String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(nome, cpf, email, senha, telefone, endereco);
    }

    public Instrutor(int id, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "alunos=" + alunos +
                '}';
    }
}
