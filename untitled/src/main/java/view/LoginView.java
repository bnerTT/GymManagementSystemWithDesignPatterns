package view;


import model.dao.GerenteDAO;
import model.domain.Gerente;
import util.ValidaLogin;

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
                        break;

                    case 2:
                        usuarioValidado = ValidaLogin.verificaInstrutor(email, senha);
                        break;

                    case 3:
                        usuarioValidado = ValidaLogin.verificaGerente(email, senha);
                        GerenteDAO gerenteDAO = new GerenteDAO();
                        Gerente gerente = gerenteDAO.buscarGerentePorEmail(email);
                        GerenteView.displayGerenteView(gerente);
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
    }

}
