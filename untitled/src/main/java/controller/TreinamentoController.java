package controller;

import model.dao.TreinamentoDAO;
import model.dao.TreinoDiaDAO;
import model.domain.usuarios.Aluno;
import model.domain.Treinamento;
import model.domain.TreinoDia;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreinamentoController {
    TreinamentoDAO treinamentoDAO = new TreinamentoDAO();
    TreinoDiaDAO treinoDiaDao = new TreinoDiaDAO();

    public void criarTreinamento(Treinamento treinamento) throws SQLException {
        treinamentoDAO.inserirTreinamento(treinamento);
        treinamentoDAO.buscarTreinamentoPorIdAluno(treinamento.getAluno());
        treinamento.setId((treinamentoDAO.buscarTreinamentoPorIdAluno(treinamento.getAluno())).getId());
    }

    public Treinamento buscarTreinamento(Aluno aluno) throws SQLException {
        return treinamentoDAO.buscarTreinamentoPorIdAluno(aluno);
    }

    public void inserirTreinoDiaEmTreinamento(Aluno aluno, Treinamento treinamento) throws SQLException {
        Scanner input = new Scanner(System.in);
        String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};

        // Para cada dia da semana, cria um treino e atividades associadas
        for (String dia : diasDaSemana) {
            System.out.println("Insira as atividades para " + dia + " (insira até 10 atividades, separadas por vírgula):");
            String atividadesInput = input.nextLine();
            List<String> atividades = Arrays.asList(atividadesInput.split(","));

            // Cria um objeto TreinoDia para o dia da semana
            TreinoDia treinoDia = new TreinoDia();
            treinoDia.setDiaSemana(dia);
            treinoDia.setTreinamento(treinamento.getId());
            treinoDia.setAtividades(atividades);

            // Insere o treino do dia no banco de dados
            TreinoDiaDAO treinoDiaDAO = new TreinoDiaDAO();
            treinoDiaDAO.inserirTreinoDia(treinoDia, treinamento.getId());
            treinoDiaDAO.inserirAtividades(treinoDia); // Insere as atividades para esse dia
        }

        // Atribuir o treinamento ao aluno
        aluno.setTreinamento(treinamento);

        System.out.println("Treinamento com treinos por semana criado com sucesso para o aluno " + aluno.getNome());
    }


    public void removerTreinoDia(Treinamento treinamento) throws SQLException {
        List<TreinoDia> treinosDias = treinoDiaDao.buscarTreinoDiasPorTreinamentoId(treinamento.getId());
        for(TreinoDia treinoDia : treinosDias) {
            treinoDiaDao.excluirTreinoPorTreinoDia(treinoDia.getId());
        }
        treinoDiaDao.excluirTreinoDiaPorTreinamento(treinamento.getId());
    }

    public void removerTreinamento(Treinamento treinamento) throws SQLException {
        treinamentoDAO.excluirTreinamento(treinamento.getId());
    }

    public void listarExerciciosPorDia(Aluno aluno) throws SQLException {
        // Buscar o treinamento associado ao aluno
        Treinamento treinamento = treinamentoDAO.buscarTreinamentoPorIdAluno(aluno);
        List<TreinoDia> treinDias = TreinoDiaDAO.buscarTreinoDiasPorTreinamentoId(treinamento.getId());
        treinamento.setExerciciosDias(treinDias);

        if (treinamento != null) {
            System.out.println("Treinamento: " + treinamento.getTipo());
            System.out.println("Período: " + treinamento.getDataInicio() + " - " + treinamento.getDataFim());

            // Verifica se o treinamento tem dias de treino associados
            List<TreinoDia> treinoDias = treinamento.getExerciciosDias();
            if (treinoDias != null && !treinoDias.isEmpty()) {
                // Percorrer os dias de treino
                for (TreinoDia treinoDia : treinoDias) {
                    System.out.println("\nDia da semana: " + treinoDia.getDiaSemana());

                    // Listar as atividades/exercícios do dia
                    List<String> atividades = treinoDia.getAtividades();
                    if (atividades == null || atividades.isEmpty()) {
                        System.out.println("Nenhum exercício para este dia.");
                    } else {
                        for (int i = 0; i < atividades.size(); i++) {
                            System.out.println((i + 1) + ". " + atividades.get(i));
                        }
                    }
                }
            } else {
                System.out.println("Nenhum dia de treino associado a este treinamento.");
            }
        } else {
            System.out.println("Treinamento não encontrado.");
        }
    }


    public void criarTreinamentoComTreinosPorSemana(Aluno aluno, Treinamento treinamento) throws SQLException {
        AlunoController alunoController = new AlunoController();
        Scanner input = new Scanner(System.in);
        alunoController.associarAlunoTreino(aluno, treinamento);

        // Dias da semana que serão preenchidos com treinos
        String[] diasDaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo"};

        // Para cada dia da semana, cria um treino e atividades associadas
        for (String dia : diasDaSemana) {
            System.out.println("Insira as atividades para " + dia + " (insira até 10 atividades, separadas por vírgula):");
            String atividadesInput = input.nextLine();
            List<String> atividades = Arrays.asList(atividadesInput.split(","));

            // Cria um objeto TreinoDia para o dia da semana
            TreinoDia treinoDia = new TreinoDia();
            treinoDia.setDiaSemana(dia);
            treinoDia.setTreinamento(treinamento.getId());  // Associa o ID do treinamento ao TreinoDia
            treinoDia.setAtividades(atividades);

            // Insere o treino do dia no banco de dados
            TreinoDiaDAO treinoDiaDAO = new TreinoDiaDAO();
            treinoDiaDAO.inserirTreinoDia(treinoDia, treinamento.getId());  // Insere o treino associado ao treinamento
            treinoDiaDAO.inserirAtividades(treinoDia);  // Insere as atividades para esse dia
        }

        System.out.println("Treinamento com treinos por semana criado com sucesso para o aluno " + aluno.getNome());
        input.close();
    }

}
