package view;

import controller.*;
import model.dao.*;
import model.domain.*;

import java.sql.SQLException;
import java.util.Scanner;

public class GerenteView {

    public static void displayGerenteView(Gerente gerente){
        int menuControle;
        int tipoUsuario;

        InstrutorController instrutorController = new InstrutorController();
        GerenteController gerenteController = new GerenteController();
        AlunoController alunoController = new AlunoController();

        Instrutor instrutor;
        Aluno aluno;
        Gerente novoGerente;
        InstrutorDAO instrutorDAO;
        AlunoDAO alunoDAO;
        GerenteDAO gerenteDAO;

        try(Scanner input = new Scanner(System.in)){
            do {
                System.out.println("Seja bem vindo, " + gerente.getNome() + ".");
                System.out.println("O que deseja fazer?");
                System.out.println("1. Cadastrar um usuário");
                System.out.println("2. Remover um usuário");
                System.out.println("3. Editar um usuário");
                System.out.println("4. Visualizar um usuário");
                System.out.println("9. Sair");
                System.out.println("Insira sua opção:");
                menuControle = input.nextInt();
                input.nextLine();

                switch (menuControle){
                    ///Cadastrar
                    case 1:
                        System.out.println("Deseja cadastrar um novo:");
                        System.out.println("1. Aluno");
                        System.out.println("2. Instrutor");
                        System.out.println("3. Gerente");
                        tipoUsuario = input.nextInt();
                        input.nextLine();

                        System.out.println("Insira o nome:");
                        String nome = input.nextLine();
                        System.out.println("Insira o CPF:");
                        String cpf = input.nextLine();
                        System.out.println("Insira o email:");
                        String email = input.nextLine();
                        System.out.println("Insira a senha:");
                        String senha = input.nextLine();
                        System.out.println("Insira o telefone:");
                        String telefone = input.nextLine();
                        System.out.println("Insira o endereco:");
                        String endereco = input.nextLine();

                        switch(tipoUsuario){
                            case 1:
                                System.out.println("Insira a matricula:");
                                String matricula = input.nextLine();
                                System.out.println("Insira o plano de matrícula:");
                                String plano = input.nextLine();
                                ///Caso validado

                                aluno = new Aluno(
                                        nome,
                                        cpf,
                                        email,
                                        senha,
                                        telefone,
                                        endereco,
                                        matricula,
                                        plano
                                );

                                System.out.println("Insira o nome do instrutor desse aluno:");
                                String nomeInstrutor = input.nextLine();
                                instrutor = instrutorController.buscarInstrutor(nomeInstrutor);
                                alunoController.associarAlunoInstrutor(aluno, instrutor);
                                alunoController.cadastrarAluno(aluno);
                                System.out.println("Aluno cadastrado com sucesso!");

                                break;

                            case 2:
                                //Caso validado
                                instrutor = new Instrutor(
                                        nome,
                                        cpf,
                                        email,
                                        senha,
                                        telefone,
                                        endereco
                                );
                                instrutorController.salvarInstrutor(instrutor);
                                System.out.println("Instrutor salvo com sucesso!");
                                break;

                            case 3:
                                System.out.println("Insira o departamento:");
                                String departamento = input.nextLine();
                                novoGerente = new Gerente(
                                        nome,
                                        cpf,
                                        email,
                                        senha,
                                        telefone,
                                        endereco,
                                        departamento
                                );

                                gerenteController.salvarGerente(novoGerente);
                                System.out.println("Gerente salvo com sucesso!");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        ///Remover
                    case 2:
                        System.out.println("Deseja remover um:");
                        System.out.println("1. Aluno");
                        System.out.println("2. Instrutor");
                        System.out.println("3. Gerente");
                        tipoUsuario = input.nextInt();
                        input.nextLine();

                        System.out.println("Insira o nome:");
                        String nomeBuscado = input.nextLine();
                        switch(tipoUsuario){
                            case 1:
                                Aluno alunoBuscado = alunoController.buscarAlunoPorNome(nomeBuscado);
                                if(alunoBuscado == null){
                                    System.out.println("Aluno não encontrado");
                                    continue;
                                }
                                alunoController.removerAluno(alunoBuscado);
                                System.out.println("Aluno removido com sucesso!");
                                break;

                            case 2:
                                Instrutor instrutorBuscado = instrutorController.buscarInstrutor(nomeBuscado);
                                if(instrutorBuscado == null){
                                    System.out.println("Instrutor não encontrado.");
                                    continue;
                                }
                                instrutorController.removerInstrutor(instrutorBuscado);
                                System.out.println("Instrutor removido com sucesso!");
                                break;

                            case 3:
                                Gerente gerenteBuscado = gerenteController.buscarGerente(nomeBuscado);
                                if(gerenteBuscado == null){
                                    System.out.println("Gerente não encontrado.");
                                    continue;
                                }
                                gerenteController.excluirGerente(gerenteBuscado);
                                System.out.println("Gerente removido com sucesso!");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;

                        ///Editar
                    case 3:
                        System.out.println("Deseja editar um:");
                        System.out.println("1. Aluno");
                        System.out.println("2. Instrutor");
                        System.out.println("3. Gerente");
                        tipoUsuario = input.nextInt();
                        input.nextLine();

                        System.out.println("Insira o nome do usuário:");
                        nome = input.nextLine();

                        switch(tipoUsuario){
                            case 1:
                                alunoDAO = new AlunoDAO();
                                aluno = alunoDAO.buscarPorNome(nome);
                                if(aluno == null){
                                    System.out.println("Aluno não encontrado.");
                                }

                                break;
                            case 2:
                                instrutorDAO = new InstrutorDAO();
                                instrutor = instrutorDAO.buscarInstrutorPorNome(nome);
                                if(instrutor == null){
                                    System.out.println("Instrutor não encontrado.");
                                }

                                break;
                            case 3:
                                gerenteDAO = new GerenteDAO();
                                novoGerente = gerenteDAO.buscarGerentePorNome(nome);
                                if(novoGerente == null){
                                    System.out.println("Gerente não encontrado.");
                                }

                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        break;

                        ///Visualizar
                    case 4:
                        System.out.println("Deseja visualizar um:");
                        System.out.println("1. Aluno");
                        System.out.println("2. Instrutor");
                        System.out.println("3. Gerente");
                        tipoUsuario = input.nextInt();
                        input.nextLine();

                        System.out.println("Insira o nome do usuário:");
                        nome = input.nextLine();
                        switch(tipoUsuario){
                            case 1:
                                aluno = alunoController.buscarAlunoPorNome(nome);
                                if(aluno == null){
                                    System.out.println("Aluno não encontrado.");
                                }
                                System.out.println(aluno);
                                break;

                            case 2:
                                instrutor = instrutorController.buscarInstrutor(nome);
                                if(instrutor == null){
                                    System.out.println("Instrutor não encontrado.");
                                }
                                System.out.println(instrutor);
                                break;

                            case 3:
                                novoGerente = gerenteController.buscarGerente(nome);
                                if(novoGerente == null){
                                    System.out.println("Gerente não encontrado.");
                                }
                                System.out.println(novoGerente);
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                    case 9:
                        System.out.println("Efetuando logout...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

            } while(menuControle != 9);

        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            displayGerenteView(gerente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
