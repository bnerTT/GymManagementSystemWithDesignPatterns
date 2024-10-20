package controller;

import model.dao.GerenteDAO;
import model.domain.usuarios.Gerente;

import java.sql.SQLException;

public class GerenteController {
    GerenteDAO gerenteDAO = new GerenteDAO();

    public void salvarGerente(Gerente gerente) throws SQLException {
        gerenteDAO.salvar(gerente);
    }

    public void excluirGerente(Gerente gerente) throws SQLException {
        gerenteDAO.deletar(gerente.getId());
    }

    public Gerente buscarGerente(String nome) throws SQLException{
        return(gerenteDAO.buscarGerentePorNome(nome));
    }

    public void editarGerente(Gerente gerente, Gerente gerenteEditado) throws SQLException {
        gerenteDAO.editar(gerente.getId(), gerenteEditado);
    }
}
