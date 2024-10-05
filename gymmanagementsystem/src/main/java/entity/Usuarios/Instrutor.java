package entity.Usuarios;

import entity.Treinamento.Treinamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instrutor extends Usuario{
    ///chave estrangeira
    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Aluno> alunos;

    public Instrutor(){
    }

    public Instrutor(int id, String nome, String cpf, String email, String senha, String endereco, String telefone) {
        super(id, nome, cpf, email, senha, endereco, telefone);
        this.alunos = new ArrayList<>();
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

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
}
