package view.instrutor;

import controller.TreinamentoController;
import model.domain.Aluno;
import model.domain.Treinamento;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class InstrutorCriarTreinoView {

    public void displayCriarTreinoView(Aluno aluno) {
        TreinamentoController treinamentoController = new TreinamentoController();

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Insira o tipo do treinamento:");
            String tipo = input.nextLine();
            System.out.println("Insira a data de início do treinamento:");
            System.out.println("Insira no formato AAAA-MM-DD, ex: 2024-10-15");
            String data = input.nextLine();
            System.out.println("Insira o período do treinamento (em dias):");
            int periodo = input.nextInt();
            input.nextLine();  // Limpa o buffer

            // Criar o treinamento com os treinos por semana
            treinamentoController.criarTreinamento(new Treinamento(tipo, LocalDate.parse(data), LocalDate.parse(data).plusDays(periodo), aluno.getId()));
            Treinamento treinamento = treinamentoController.buscarTreinamento(aluno);
            treinamentoController.criarTreinamentoComTreinosPorSemana(aluno, treinamento, input);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
