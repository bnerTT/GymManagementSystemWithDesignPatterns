package util;

import model.dao.AlunoDAO;
import model.dao.GerenteDAO;
import model.dao.InstrutorDAO;
import model.domain.Aluno;
import model.domain.Gerente;
import model.domain.Instrutor;

import java.sql.SQLException;

public class ValidaLogin {

        public static boolean verificaAlunoLogin(String email, String senha) throws SQLException {
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.buscarAlunoPorEmail(email);
        if (aluno == null) {
            return false;
        }
        return aluno.getSenha().equals(senha);
        }

        public static boolean verificaInstrutor(String email, String senha) throws SQLException {
            InstrutorDAO instrutorDAO = new InstrutorDAO();
            Instrutor instrutor = instrutorDAO.buscarInstrutorPorEmail(email);
            if (instrutor == null) {
                return false;
            }
            return instrutor.getSenha().equals(senha);
        }

        public static boolean verificaGerente(String email, String senha) throws SQLException {
            GerenteDAO gerenteDAO = new GerenteDAO();
            Gerente gerente = gerenteDAO.buscarGerentePorEmail(email);
            if (gerente == null) {
                return false;
            }
            return gerente.getSenha().equals(senha);
        }
}
