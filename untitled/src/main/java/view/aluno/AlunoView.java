package view.aluno;

import controller.FrequenciaController;
import controller.TreinamentoController;
import model.domain.Aluno;

import java.sql.SQLException;
import java.util.Scanner;

public class AlunoView {

    public void displayAlunoView(Aluno aluno) {
        int opcao;
        TreinamentoController treinamentoController = new TreinamentoController();
        FrequenciaController frequenciaController = new FrequenciaController();

        try(Scanner input = new Scanner(System.in)){
            do {
                System.out.println("Seja bem vindo, " + aluno.getNome() + ".");
                System.out.println("O que deseja fazer?");
                System.out.println("1. Visualizar treino");
                System.out.println("2. Visualizar frequência");
                System.out.println("9. Sair");
                System.out.println("Insira sua opção:");
                opcao = input.nextInt();
                input.nextLine();

                switch(opcao){
                    case 1:
                        System.out.println("Visualizar treino");
                        treinamentoController.listarExerciciosPorDia(aluno);
                        break;

                    case 2:
                        System.out.println("Visualizar frequência");
                        frequenciaController.listarFrequencia(aluno);
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
