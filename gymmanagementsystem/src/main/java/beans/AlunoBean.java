package beans;

import entity.Usuarios.Aluno;

public class AlunoBean {
    private Aluno aluno = new Aluno();

    public void cadastrarAluno(Aluno aluno){
        System.out.println("Aluno cadastrado");
    }

    public void removerAluno(Aluno aluno){
        System.out.println("Aluno removido com sucesso");
    }

    public void editarAluno(Aluno aluno){
        System.out.println("Aluno editado");
    }

    public Aluno buscarAluno(){
        System.out.println("Aluno encontrado");
        return null;
    }

    public void listarAlunos(){
        System.out.println("Alunos listado");
    }
}
