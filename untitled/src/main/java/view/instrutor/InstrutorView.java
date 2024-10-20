package view.instrutor;

import controller.AlunoController;
import controller.FrequenciaController;
import controller.TreinamentoController;
import model.domain.usuarios.Aluno;
import model.domain.usuarios.Instrutor;

import java.sql.SQLException;
import java.util.Scanner;

public class InstrutorView {

    public void displayInstrutorView(Instrutor instrutor) {
        int opcao;
        TreinamentoController controller = new TreinamentoController();
        FrequenciaController frequenciaController = new FrequenciaController();
        AlunoController alunoController = new AlunoController();

        try (Scanner input = new Scanner(System.in)) {
            do {
                System.out.println("Seja bem vindo, " + instrutor.getNome() + ".");
                System.out.println("O que deseja fazer?");
                System.out.println("1. Criar treinamento para aluno.");
                System.out.println("2. Registrar frequência para aluno.");
                System.out.println("9. Sair");
                System.out.println("Insira sua opção:");
                opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {

                    case 1:
                        System.out.println("Criar treino para aluno");
                        System.out.println("Insira o nome do aluno:");
                        String nome = input.nextLine();
                        Aluno aluno = alunoController.buscarAlunoPorNome(nome);
                        if (aluno == null) {
                            System.out.println("Aluno não encontrado.");
                            break;
                        }
                        InstrutorCriarTreinoView instrutorCriarTreinoView = new InstrutorCriarTreinoView();
                        instrutorCriarTreinoView.displayCriarTreinoView(aluno);
                        break;
                    case 2:
                        System.out.println("Editar treino de aluno");
                        break;
                    case 3:
                        System.out.println("Excluir treino de aluno");
                        break;
                    case 4:
                        System.out.println("Registrar frequência de aluno");
                        break;

                    case 9:
                        break;

                    default:
                        break;
                }

            } while (opcao != 9);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
