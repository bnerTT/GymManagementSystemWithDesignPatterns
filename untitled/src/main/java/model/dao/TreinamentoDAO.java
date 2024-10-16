package model.dao;

import model.database.DB;
import model.domain.Aluno;
import model.domain.Treinamento;
import model.domain.TreinoDia;

import java.sql.*;
import java.util.List;

public class TreinamentoDAO {

    public void inserirTreinamento(Treinamento treinamento) throws SQLException {
        var sql = "INSERT INTO treinamento (tipo, data_inicio, data_fim, aluno_id) VALUES (?, ?, ?, ?)";

        try (var conn = DB.connect()) {
            assert conn != null;
            try (var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, treinamento.getTipo());
                pstmt.setDate(2, Date.valueOf(treinamento.getDataInicio()));
                pstmt.setDate(3, Date.valueOf(treinamento.getDataFim()));
                pstmt.setInt(4, treinamento.getAlunoId());
                int insertedRows = pstmt.executeUpdate();

                if (insertedRows > 0) {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        treinamento.setId(rs.getInt(1));  // Aqui o ID do treinamento deve ser definido
                    }
                }
            }
        }
    }


    /*public void inserirTreinamento(Treinamento treinamento) throws SQLException {
        var sql = "INSERT INTO treinamento DEFAULT VALUES";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                int insertedRow = pstmt.executeUpdate();

                if (insertedRow > 0) {
                    pstmt.getGeneratedKeys();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }*/

    public Treinamento buscarTreinamentoPorIdAluno(Aluno aluno) throws SQLException {
        String sql = "SELECT * FROM treinamento WHERE aluno_id = ?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, aluno.getId());  // Certifique-se de que está usando a chave correta (por exemplo, aluno_id)
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Treinamento treinamento = new Treinamento();
                treinamento.setId(rs.getInt("id"));
                treinamento.setTipo(rs.getString("tipo"));
                treinamento.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                treinamento.setDataFim(rs.getDate("data_fim").toLocalDate());
                treinamento.setAlunoId(rs.getInt("aluno_id"));
                return treinamento;
            }
        }
        return null;  // Se não encontrar, retorne null
    }


    public Treinamento buscarTreinamentoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM treinamento WHERE id = ?";
        try(var conn = DB.connect()){
            assert conn != null;

            try(PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstmt.setInt(1, id);

                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    Treinamento treinamento = new Treinamento();
                    treinamento.setId(rs.getInt("id"));
                    treinamento.setTipo(rs.getString("tipo"));
                    treinamento.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                    treinamento.setDataInicio(rs.getDate("data_fim").toLocalDate());
                    treinamento.setAlunoId(rs.getInt("aluno_id"));
                    treinamento.setExerciciosDias(buscarTreinoDiasPorTreinamentoId(id));
                    return treinamento;
                }
                return null;
            }
        }
    }

    public List<TreinoDia> buscarTreinoDiasPorTreinamentoId(int treinamentoId) throws SQLException {
        try(var conn = DB.connect()){
            assert conn != null;

            TreinoDia treinoDia = new TreinoDia();
            return TreinoDiaDAO.buscarTreinoDiasPorTreinamentoId(treinamentoId);
        }
    }

    public void excluirTreinamento(int id) throws SQLException {
        var sql = "DELETE FROM treinamento WHERE id = ?";

        try(var conn = DB.connect()) {
            assert conn != null;
            try(var pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    }

