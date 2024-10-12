package model.dao;

import model.database.DB;
import model.domain.TreinoDia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreinoDiaDAO {

    public void inserirTreinoDia(TreinoDia treinoDia, int treinamentoId) throws SQLException {
        var sql = "INSERT INTO treinodia (treinamento_id, diasemana) VALUES (?, ?)";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstmt.setInt(1, treinamentoId);
                pstmt.setString(2, treinoDia.getDiaSemana());

                int insertedRow = pstmt.executeUpdate();

                if (insertedRow > 0) {
                    pstmt.getGeneratedKeys();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inserirAtividades(TreinoDia treinoDia) throws SQLException {
        var sql = "INSERT INTO treino(treino_dia_id, exercicio_1, exercicio_2, exercicio_3, exercicio_4, exercicio_5, exercicio_6, exercicio_7, exercicio_8, exercicio_9, exercicio_10) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?)";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                    pstmt.setInt(1, treinoDia.getId());


                List<String> atividades = treinoDia.getAtividades();
                for (int i = 0; i < 10; i++) {
                    if (i < atividades.size()) {
                        pstmt.setString(i + 2, atividades.get(i)); // i + 2 pois o primeiro é treino_dia_id
                    } else {
                        pstmt.setNull(i + 2, Types.VARCHAR); // Define null para os exercícios que não existem
                    }
                }

                pstmt.executeUpdate();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<TreinoDia> buscarTreinoDiasPorTreinamentoId(int treinamentoId) throws SQLException {
        var sql = "SELECT * FROM treinodia WHERE treinamento_id = ?";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstmt.setInt(1, treinamentoId);

                ResultSet rs = pstmt.executeQuery();
                List<TreinoDia> treinoDias = new ArrayList<>();
                while(rs.next()){
                    TreinoDia treinoDia = new TreinoDia();
                    treinoDia.setId(rs.getInt("id"));
                    treinoDia.setDiaSemana(rs.getString("diasemana"));
                    treinoDia.setAtividades(buscarAtividadesDoDia(rs.getInt("id")));
                    treinoDias.add(treinoDia);
                }
                return treinoDias;
            }
        }
    }

    public List<String> buscarAtividadesDoDia(int treinamentoId) throws SQLException {
        var sql = "SELECT * FROM treino WHERE treino.treino_dia_id = ?";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, treinamentoId);

                ResultSet rs = pstmt.executeQuery();

                List<String> atividades = new ArrayList<>();
                if (rs.next()) {
                    for (int i = 1; i <= 10; i++) {
                        String atividade = rs.getString("exercicio_" + i);
                        if (atividade != null) {
                            atividades.add(atividade);
                        }
                    }
                }
                return atividades;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void excluirTreinoPorTreinoDia(int treinoDiaId) throws SQLException {
        var sql = "DELETE FROM treino WHERE treino_dia_id = ?";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, treinoDiaId);
                pstmt.executeUpdate();
            }
        }
    }

    public void excluirTreinoDiaPorTreinamento(int idTreinamento) throws SQLException {
        var sql = "DELETE FROM TreinoDia WHERE treinamento_id = ?";

        try (var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, idTreinamento);
                pstmt.executeUpdate();
            }
        }
    }

    public void excluirTreinoDia(int id) throws SQLException {
        var sql = "DELETE FROM TreinoDia WHERE id = ?";

        try (var conn = DB.connect()) {
            assert conn != null;

            try (var pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        }
    }
}
