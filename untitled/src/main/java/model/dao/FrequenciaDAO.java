package model.dao;

import model.database.DB;
import model.domain.Frequencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequenciaDAO {


    //Salvar frequencia
    public void salvar(Frequencia frequencia) throws SQLException {
        var sql = "INSERT INTO frequencia DEFAULT VALUES";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
                int insertedRow = pstmt.executeUpdate();

                if (insertedRow > 0) {
                    pstmt.getGeneratedKeys();

                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public void inserirDatas(int frequenciaId, List<LocalDate> datas) throws SQLException {
        String sql = "INSERT INTO frequenciadatas (frequencia_id, data) VALUES (?,?)";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
                for (LocalDate data : datas) {
                    pstmt.setInt(1, frequenciaId);
                    pstmt.setDate(2, Date.valueOf(data));
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }
        }
    }

    public Frequencia buscarFrequenciaPorId(int id) throws SQLException {
        String sql = "SELECT data FROM FrequenciaDatas WHERE frequencia_id = ?";

        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            var rs = pstmt.executeQuery();

            List<LocalDate> datas = new ArrayList<>();
            while (rs.next()) {
                datas.add(rs.getDate("data").toLocalDate());
            }

            Frequencia frequencia = new Frequencia();
            frequencia.setId(id);
            frequencia.setFrequencia(datas);

            return frequencia;
        }
    }

    public Frequencia buscarFrequenciasPorId(int id) throws SQLException {
        String sql = "SELECT data FROM FrequenciaDatas WHERE frequencia_id = ?";

        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            var rs = pstmt.executeQuery();
            List<LocalDate> datas = new ArrayList<>();
            while (rs.next()) {
                datas.add(rs.getDate("data").toLocalDate());
            }
            Frequencia frequencia = new Frequencia();
            frequencia.setFrequencia(datas);
            return frequencia;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Frequencia> buscarTodasFrequencias() throws SQLException {
        String sql = "SELECT f.id, fd.data FROM frequencia f " +
                "JOIN frequenciadatas fd ON f.id = fd.frequencia_id " +
                "ORDER BY f.id, fd.data";

        List<Frequencia> frequencias = new ArrayList<>();
        Map<Integer, Frequencia> frequenciaMap = new HashMap<>();

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int frequenciaId = rs.getInt("id");
                LocalDate data = rs.getDate("data").toLocalDate();

                Frequencia frequencia = frequenciaMap.get(frequenciaId);
                if (frequencia == null) {
                    frequencia = new Frequencia();
                    frequencia.setId(frequenciaId);
                    frequencia.setFrequencia(new ArrayList<>());
                    frequenciaMap.put(frequenciaId, frequencia);
                }

                frequencia.getFrequencia().add(data);
            }
        }

        frequencias.addAll(frequenciaMap.values());
        return frequencias;
    }

    // Método para atualizar uma frequência existente
    /*public void atualizarFrequencia(Frequencia frequencia) throws SQLException {
        // Exclui as datas antigas
        String deleteSql = "DELETE FROM FrequenciaDatas WHERE frequencia_id = ?";
        PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
        deleteStmt.setInt(1, frequencia.getId());
        deleteStmt.executeUpdate();

        // Insere as novas datas
        inserirDatas(frequencia.getId(), frequencia.getFrequencia());
    }

    // Método para excluir uma frequência do banco de dados
    public void excluirFrequencia(int id) throws SQLException {
        // Exclui as datas associadas
        String deleteDatasSql = "DELETE FROM FrequenciaDatas WHERE frequencia_id = ?";
        PreparedStatement deleteDatasStmt = connection.prepareStatement(deleteDatasSql);
        deleteDatasStmt.setInt(1, id);
        deleteDatasStmt.executeUpdate();

        // Exclui a frequência
        String deleteFrequenciaSql = "DELETE FROM Frequencia WHERE id = ?";
        PreparedStatement deleteFrequenciaStmt = connection.prepareStatement(deleteFrequenciaSql);
        deleteFrequenciaStmt.setInt(1, id);
        deleteFrequenciaStmt.executeUpdate();
    }*/
}
