package model.domain;

import java.util.List;

public class Instrutor extends Usuario {
    private List<Aluno> alunos;

    public Instrutor(){
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
