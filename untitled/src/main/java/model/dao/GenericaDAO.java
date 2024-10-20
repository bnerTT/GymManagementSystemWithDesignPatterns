package model.dao;

import model.domain.usuarios.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface GenericaDAO<T extends Usuario> {
    void salvar(T usuario) throws SQLException;
    ///void atualizar(T usuario) throws SQLException;
    void deletar(int id) throws SQLException;
    T buscarPorId(int id) throws SQLException;
    List<T> listar() throws SQLException;
}
