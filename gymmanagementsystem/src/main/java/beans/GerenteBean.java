package beans;

import entity.Usuarios.Aluno;
import entity.Usuarios.Instrutor;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class GerenteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    ///Utilizado em cadastros
    private Aluno novoAluno;
    private Instrutor novoInstrutor;

    ///Utilizado em associacao
    private Aluno alunoAssociado;
    private Instrutor instrutorAssociado;

    ///Utilizado para exibir
    private List<Aluno> alunos;
    private List<Instrutor> instrutores;

    ///Injecao de servicos
    @Inject
    private AlunoService alunoService;

    @Inject
    private InstrutorService instrutorService;

    @PostConstruct
    public void init() {
        novoAluno = new Aluno();
        novoInstrutor = new Instrutor();

        atualizarListas();
    }

    public void associarAluno(Aluno aluno, Instrutor instrutor){
        instrutor.getAlunos().add(aluno);

    }

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

    public void cadastrarInstrutor(Instrutor instrutor){
        System.out.println("Instrutor cadastrado");
    }

    public void removerInstrutor(Instrutor instrutor){
        System.out.println("Instrutor removido com sucesso");
    }

    public void editarInstrutor(Instrutor instrutor){
        System.out.println("Instrutor editado");
    }

    public Instrutor buscarInstrutor(){
        System.out.println("Instrutor encontrado");
        return null;
    }

    public void listarInstrutor(){
        System.out.println("Instrutores listados");
    }


}
