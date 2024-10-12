package view;

import controller.AlunoController;
import controller.GerenteController;
import controller.InstrutorController;
import model.domain.Aluno;
import model.domain.Gerente;
import model.domain.Instrutor;

import java.sql.SQLException;
import java.util.Scanner;

public class GerenteEditaView {

    public void editarAluno(Aluno aluno, Scanner input) throws SQLException {
        AlunoController alunoController = new AlunoController();
        int opcao;
        boolean nomeAlterado = false, cpfAlterado = false, emailAlterado = false, senhaAlterado = false;
        boolean telefoneAlterado = false, enderecoAlterado = false, matriculaAlterado = false;
        boolean planoAlterado = false, instrutorAlterado = false;

        String novoNome = null, novoCpf = null, novoEmail = null, novaSenha = null;
        String novoTelefone = null, novoEndereco = null, novaMatricula = null, novoPlano = null;
        String novoInstrutor = null;

        do {
            System.out.println("Qual atributo você deseja editar do aluno " + aluno.getNome() + "?");
            System.out.println("1. Nome");
            System.out.println("2. CPF");
            System.out.println("3. Email");
            System.out.println("4. Senha");
            System.out.println("5. Telefone");
            System.out.println("6. Endereço");
            System.out.println("7. Matrícula");
            System.out.println("8. Plano");
            System.out.println("9. Instrutor");
            System.out.println("0. Finalizar");
            opcao = input.nextInt();
            input.nextLine();  // Limpa o buffer
            Aluno alunoAlterado = new Aluno();
            switch (opcao) {
                case 1:
                    System.out.println("Insira o novo nome:");
                    novoNome = input.nextLine();
                    nomeAlterado = true;
                    break;
                case 2:
                    System.out.println("Insira o novo CPF:");
                    novoCpf = input.nextLine();
                    cpfAlterado = true;
                    break;
                case 3:
                    System.out.println("Insira o novo email:");
                    novoEmail = input.nextLine();
                    emailAlterado = true;
                    break;
                case 4:
                    System.out.println("Insira a nova senha:");
                    novaSenha = input.nextLine();
                    senhaAlterado = true;
                    break;
                case 5:
                    System.out.println("Insira o novo telefone:");
                    novoTelefone = input.nextLine();
                    telefoneAlterado = true;
                    break;
                case 6:
                    System.out.println("Insira o novo endereço:");
                    novoEndereco = input.nextLine();
                    enderecoAlterado = true;
                    break;
                case 7:
                    System.out.println("Insira a nova matrícula:");
                    novaMatricula = input.nextLine();
                    matriculaAlterado = true;
                    break;
                case 8:
                    System.out.println("Insira o novo plano:");
                    novoPlano = input.nextLine();
                    planoAlterado = true;
                    break;
                case 9:
                    System.out.println("Insira o novo instrutor:");
                    novoInstrutor = input.nextLine();
                    // Supondo que você tenha um método para alterar o instrutor.
                    InstrutorController instrutorController = new InstrutorController();
                    alunoAlterado.setInstrutor(instrutorController.buscarInstrutor(novoInstrutor));
                    instrutorAlterado = true;
                    break;
                case 0:
                    System.out.println("Confirme as seguintes alterações:");
                    if (nomeAlterado) {
                        System.out.println("Nome: " + aluno.getNome() + " -> " + novoNome);
                        alunoAlterado.setNome(novoNome);
                    } else{
                        alunoAlterado.setNome(aluno.getNome());
                    }
                    if (cpfAlterado) {
                        System.out.println("CPF: " + aluno.getCpf() + " -> " + novoCpf);
                        alunoAlterado.setCpf(novoCpf);
                    } else {
                        alunoAlterado.setCpf(aluno.getCpf());
                    }
                    if (emailAlterado) {
                        System.out.println("Email: " + aluno.getEmail() + " -> " + novoEmail);
                        alunoAlterado.setEmail(novoEmail);
                    } else{
                        alunoAlterado.setEmail(aluno.getEmail());
                    }
                    if (senhaAlterado) {
                        System.out.println("Senha: [Alterada]");
                        alunoAlterado.setSenha(novaSenha);
                    } else{
                        alunoAlterado.setSenha(aluno.getSenha());
                    }
                    if (telefoneAlterado) {
                        System.out.println("Telefone: " + aluno.getTelefone() + " -> " + novoTelefone);
                        alunoAlterado.setTelefone(novoTelefone);
                    } else{
                        alunoAlterado.setTelefone(aluno.getTelefone());
                    }
                    if (enderecoAlterado) {
                        System.out.println("Endereço: " + aluno.getEndereco() + " -> " + novoEndereco);
                        alunoAlterado.setEndereco(novoEndereco);
                    } else {
                        alunoAlterado.setEndereco(aluno.getEndereco());
                    }
                    if (matriculaAlterado) {
                        System.out.println("Matrícula: " + aluno.getMatricula() + " -> " + novaMatricula);
                        alunoAlterado.setMatricula(novaMatricula);
                    } else{
                        alunoAlterado.setMatricula(aluno.getMatricula());
                    }
                    if (planoAlterado) {
                        System.out.println("Plano: " + aluno.getPlano() + " -> " + novoPlano);
                        alunoAlterado.setPlano(novoPlano);
                    } else {
                        alunoAlterado.setPlano(aluno.getPlano());
                    }
                    if (instrutorAlterado) {
                        System.out.println("Instrutor: [Alterado]");
                        ///Setar novo instrutor
                    } else {
                        alunoAlterado.setInstrutor(aluno.getInstrutor());
                    }

                    System.out.println("Deseja confirmar as alterações?/n1. Sim/n2. Não");
                    int confirma = input.nextInt();
                    switch(confirma){
                        case 1:
                            alunoController.editar(aluno, alunoAlterado);
                            System.out.println("Aluno editado com sucesso.");
                            break;
                        case 2:
                            System.out.println("Alteracoes desfeitas.");
                            break;
                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }

    public void editarInstrutor(Instrutor instrutor, Scanner input) throws SQLException {
        InstrutorController instrutorController = new InstrutorController();
        int opcao;
        boolean nomeAlterado = false, cpfAlterado = false, emailAlterado = false, senhaAlterado = false;
        boolean telefoneAlterado = false, enderecoAlterado = false;

        String novoNome = null, novoCpf = null, novoEmail = null, novaSenha = null;
        String novoTelefone = null, novoEndereco = null;

        do {
            System.out.println("Qual atributo você deseja editar do instrutor " + instrutor.getNome() + "?");
            System.out.println("1. Nome");
            System.out.println("2. CPF");
            System.out.println("3. Email");
            System.out.println("4. Senha");
            System.out.println("5. Telefone");
            System.out.println("6. Endereço");
            System.out.println("0. Finalizar");
            opcao = input.nextInt();
            input.nextLine();  // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Insira o novo nome:");
                    novoNome = input.nextLine();
                    nomeAlterado = true;
                    break;
                case 2:
                    System.out.println("Insira o novo CPF:");
                    novoCpf = input.nextLine();
                    cpfAlterado = true;
                    break;
                case 3:
                    System.out.println("Insira o novo email:");
                    novoEmail = input.nextLine();
                    emailAlterado = true;
                    break;
                case 4:
                    System.out.println("Insira a nova senha:");
                    novaSenha = input.nextLine();
                    senhaAlterado = true;
                    break;
                case 5:
                    System.out.println("Insira o novo telefone:");
                    novoTelefone = input.nextLine();
                    telefoneAlterado = true;
                    break;
                case 6:
                    System.out.println("Insira o novo endereço:");
                    novoEndereco = input.nextLine();
                    enderecoAlterado = true;
                    break;
                case 0:
                    Instrutor instrutorAlterado = new Instrutor();
                    System.out.println("Confirme as seguintes alterações:");
                    if (nomeAlterado) {
                        System.out.println("Nome: " + instrutor.getNome() + " -> " + novoNome);
                        instrutorAlterado.setNome(novoNome);
                    } else {
                        instrutorAlterado.setNome(instrutor.getNome());
                    }
                    if (cpfAlterado) {
                        System.out.println("CPF: " + instrutor.getCpf() + " -> " + novoCpf);
                        instrutorAlterado.setCpf(novoCpf);
                    } else {
                        instrutorAlterado.setCpf(instrutor.getCpf());
                    }
                    if (emailAlterado) {
                        System.out.println("Email: " + instrutor.getEmail() + " -> " + novoEmail);
                        instrutorAlterado.setEmail(novoEmail);
                    } else {
                        instrutorAlterado.setEmail(instrutor.getEmail());
                    }
                    if (senhaAlterado) {
                        System.out.println("Senha: [Alterada]");
                        instrutorAlterado.setSenha(novaSenha);
                    } else {
                        instrutorAlterado.setSenha(instrutor.getSenha());
                    }
                    if (telefoneAlterado) {
                        System.out.println("Telefone: " + instrutor.getTelefone() + " -> " + novoTelefone);
                        instrutorAlterado.setTelefone(novoTelefone);
                    } else {
                        instrutorAlterado.setTelefone(instrutor.getTelefone());
                    }
                    if (enderecoAlterado) {
                        System.out.println("Endereço: " + instrutor.getEndereco() + " -> " + novoEndereco);
                        instrutorAlterado.setEndereco(novoEndereco);
                    } else {
                        instrutorAlterado.setEndereco(instrutor.getEndereco());
                    }

                    System.out.println("Deseja confirmar as alterações?\n1. Sim\n2. Não");
                    int confirma = input.nextInt();
                    switch (confirma) {
                        case 1:
                            instrutorController.editarInstrutor(instrutor, instrutorAlterado);
                            System.out.println("Instrutor editado com sucesso.");
                            break;
                        case 2:
                            System.out.println("Alterações desfeitas.");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }


    public void editarGerente(Gerente gerente, Scanner input) throws SQLException {
        GerenteController gerenteController = new GerenteController();
        int opcao;
        boolean nomeAlterado = false, cpfAlterado = false, emailAlterado = false, senhaAlterado = false;
        boolean telefoneAlterado = false, enderecoAlterado = false, departamentoAlterado = false;

        String novoNome = null, novoCpf = null, novoEmail = null, novaSenha = null;
        String novoTelefone = null, novoEndereco = null, novoDepartamento = null;

        do {
            System.out.println("Qual atributo você deseja editar do gerente " + gerente.getNome() + "?");
            System.out.println("1. Nome");
            System.out.println("2. CPF");
            System.out.println("3. Email");
            System.out.println("4. Senha");
            System.out.println("5. Telefone");
            System.out.println("6. Endereço");
            System.out.println("7. Departamento");
            System.out.println("0. Finalizar");
            opcao = input.nextInt();
            input.nextLine();  // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Insira o novo nome:");
                    novoNome = input.nextLine();
                    nomeAlterado = true;
                    break;
                case 2:
                    System.out.println("Insira o novo CPF:");
                    novoCpf = input.nextLine();
                    cpfAlterado = true;
                    break;
                case 3:
                    System.out.println("Insira o novo email:");
                    novoEmail = input.nextLine();
                    emailAlterado = true;
                    break;
                case 4:
                    System.out.println("Insira a nova senha:");
                    novaSenha = input.nextLine();
                    senhaAlterado = true;
                    break;
                case 5:
                    System.out.println("Insira o novo telefone:");
                    novoTelefone = input.nextLine();
                    telefoneAlterado = true;
                    break;
                case 6:
                    System.out.println("Insira o novo endereço:");
                    novoEndereco = input.nextLine();
                    enderecoAlterado = true;
                    break;
                case 7:
                    System.out.println("Insira o novo departamento:");
                    novoDepartamento = input.nextLine();
                    departamentoAlterado = true;
                    break;
                case 0:
                    Gerente gerenteAlterado = new Gerente();
                    System.out.println("Confirme as seguintes alterações:");
                    if (nomeAlterado) {
                        System.out.println("Nome: " + gerente.getNome() + " -> " + novoNome);
                        gerenteAlterado.setNome(novoNome);
                    } else {
                        gerenteAlterado.setNome(gerente.getNome());
                    }
                    if (cpfAlterado) {
                        System.out.println("CPF: " + gerente.getCpf() + " -> " + novoCpf);
                        gerenteAlterado.setCpf(novoCpf);
                    } else {
                        gerenteAlterado.setCpf(gerente.getCpf());
                    }
                    if (emailAlterado) {
                        System.out.println("Email: " + gerente.getEmail() + " -> " + novoEmail);
                        gerenteAlterado.setEmail(novoEmail);
                    } else {
                        gerenteAlterado.setEmail(gerente.getEmail());
                    }
                    if (senhaAlterado) {
                        System.out.println("Senha: [Alterada]");
                        gerenteAlterado.setSenha(novaSenha);
                    } else {
                        gerenteAlterado.setSenha(gerente.getSenha());
                    }
                    if (telefoneAlterado) {
                        System.out.println("Telefone: " + gerente.getTelefone() + " -> " + novoTelefone);
                        gerenteAlterado.setTelefone(novoTelefone);
                    } else {
                        gerenteAlterado.setTelefone(gerente.getTelefone());
                    }
                    if (enderecoAlterado) {
                        System.out.println("Endereço: " + gerente.getEndereco() + " -> " + novoEndereco);
                        gerenteAlterado.setEndereco(novoEndereco);
                    } else {
                        gerenteAlterado.setEndereco(gerente.getEndereco());
                    }
                    if (departamentoAlterado) {
                        System.out.println("Departamento: " + gerente.getDepartamento() + " -> " + novoDepartamento);
                        gerenteAlterado.setDepartamento(novoDepartamento);
                    } else {
                        gerenteAlterado.setDepartamento(gerente.getDepartamento());
                    }

                    System.out.println("Deseja confirmar as alterações?\n1. Sim\n2. Não");
                    int confirma = input.nextInt();
                    switch (confirma) {
                        case 1:
                            gerenteController.editarGerente(gerente, gerenteAlterado);
                            System.out.println("Gerente editado com sucesso.");
                            break;
                        case 2:
                            System.out.println("Alterações desfeitas.");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }


}
