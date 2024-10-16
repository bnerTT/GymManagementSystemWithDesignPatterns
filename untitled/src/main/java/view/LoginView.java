package view;


import controller.AlunoController;
import controller.InstrutorController;
import model.dao.GerenteDAO;
import model.domain.Aluno;
import model.domain.Gerente;
import model.domain.Instrutor;
import util.ValidaLogin;
import view.aluno.AlunoView;
import view.gerente.GerenteView;
import view.instrutor.InstrutorView;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {

    static ValidaLogin validaLogin;

    public static void displayLogin(){
        Scanner input = new Scanner(System.in);
        String email;
        String senha;
        int escolha;
        boolean usuarioValidado = false;

        System.out.println("Bem vindo ao Sistema CT Fire");
        try{
            do{
                System.out.println("Faça login para acessar o sistema:\n\n");
                System.out.println("Insira o seu tipo de login:");
                System.out.println("1. Aluno");
                System.out.println("2. Instrutor");
                System.out.println("3. Gerente");
                escolha = input.nextInt();

                //Limpa buffer
                input.nextLine();

                System.out.println("Email:");
                email = input.nextLine();
                System.out.println("Insira a senha:");
                senha = input.nextLine();
                //Verificação de dados


                switch(escolha){
                    case 1:
                        usuarioValidado = ValidaLogin.verificaAlunoLogin(email, senha);
                        AlunoController alunoController = new AlunoController();
                        Aluno aluno = alunoController.buscarAlunoPorEmail(email);
                        AlunoView alunoView = new AlunoView();
                        alunoView.displayAlunoView(aluno);

                        usuarioValidado = false;

                        break;

                    case 2:
                        usuarioValidado = ValidaLogin.verificaInstrutor(email, senha);
                        InstrutorController instrutorController = new InstrutorController();
                        Instrutor instrutor = instrutorController.buscarInstrutorEmail(email);
                        InstrutorView instrutorView = new InstrutorView();
                        instrutorView.displayInstrutorView(instrutor);

                        usuarioValidado = false;
                        break;

                    case 3:
                        usuarioValidado = ValidaLogin.verificaGerente(email, senha);
                        GerenteDAO gerenteDAO = new GerenteDAO();
                        Gerente gerente = gerenteDAO.buscarGerentePorEmail(email);
                        GerenteView.displayGerenteView(gerente);

                        usuarioValidado = false;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } while(!usuarioValidado);

        } catch (NumberFormatException e){
            System.out.println("Entrada inválida.");
            LoginView.displayLogin();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        input.close();
    }

}
