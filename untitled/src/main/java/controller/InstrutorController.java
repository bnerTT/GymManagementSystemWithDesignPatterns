package controller;

import model.dao.InstrutorDAO;
import model.domain.Instrutor;

import java.sql.SQLException;

public class InstrutorController {
    InstrutorDAO instrutorDAO = new InstrutorDAO();

    public void salvarInstrutor(Instrutor instrutor) throws SQLException {
        instrutorDAO.salvar(instrutor);
    }

    public void editarInstrutor(Instrutor instrutor, Instrutor instrutorEditado) throws SQLException {
        instrutorDAO.editar(instrutor.getId(), instrutorEditado);
    }

    public void removerInstrutor(Instrutor instrutor) throws SQLException {
        ///Efetuar metodo de tirar o treinador_id dos alunos associados
        instrutorDAO.deletar(instrutor.getId());
    }

    public Instrutor buscarInstrutor(String nome) throws SQLException {
        Instrutor instrutor = instrutorDAO.buscarInstrutorPorNome(nome);
        if(instrutor == null){
            System.out.println("Instrutor não encontrado");
            return null;
        }
        return instrutor;
    }
}
