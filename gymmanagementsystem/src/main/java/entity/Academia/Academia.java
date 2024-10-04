package entity.Academia;

import entity.Usuarios.Aluno;
import entity.Usuarios.Gerente;
import entity.Usuarios.Instrutor;

import java.util.ArrayList;

public class Academia {
    private int id;
    private ArrayList<Aluno> alunos;
    private ArrayList<Instrutor> instrutores;

    public Academia(int id){
        this.id = id;
        this.alunos = new ArrayList<>();
        this.instrutores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(ArrayList<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }
}
