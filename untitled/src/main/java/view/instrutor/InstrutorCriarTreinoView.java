package view.instrutor;

import controller.TreinamentoController;
import model.domain.TreinamentoFactory;
import model.domain.usuarios.Aluno;
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
            Treinamento treinamento = TreinamentoFactory.criaTreinamento();
            treinamento.setTipo(tipo);
            treinamento.setDataInicio(LocalDate.parse(data));
            treinamento.setDataFim(LocalDate.parse(data).plusDays(periodo));
            treinamento.setAluno(aluno);
            treinamentoController.criarTreinamento(treinamento);
            treinamentoController.criarTreinamentoComTreinosPorSemana(aluno, treinamento);

            System.out.println("Treinamento criado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return;
    }

}
