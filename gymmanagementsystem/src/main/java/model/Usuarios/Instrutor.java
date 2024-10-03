package model.Usuarios;

import java.util.List;

public class Instrutor extends Usuario{
    private List<Aluno> alunos;

    public Instrutor(int id, String nome, String cpf, String email, String senha, String endereco, String telefone, List<Aluno> alunos) {
        super(id, nome, cpf, email, senha, endereco, telefone);
        this.alunos = alunos;
    }

    public void registrarFrequencia(Aluno aluno){
        System.out.println("Frequencia registrada");
    }

    public void criarTreinamento(Aluno aluno, String tipo){
        System.out.println("Treinamento criado");
    }

    public void editarTreinamento(Treinamento treinamento){
        System.out.println("Treinamento editado");
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    
}
