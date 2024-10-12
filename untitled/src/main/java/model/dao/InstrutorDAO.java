package model.dao;

import model.database.DB;
import model.domain.Aluno;
import model.domain.Frequencia;
import model.domain.Instrutor;
import model.domain.Treinamento;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InstrutorDAO implements GenericaDAO<Instrutor>{

    public void salvar(Instrutor instrutor) throws SQLException {
        var sql = "INSERT INTO instrutor(nome, cpf, email, senha, telefone, endereco)"
        + "VALUES (?, ?, ?, ?, ?, ?)";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstmt.setString(1, instrutor.getNome());
                pstmt.setString(2, instrutor.getCpf());
                pstmt.setString(3, instrutor.getEmail());
                pstmt.setString(4, instrutor.getSenha());
                pstmt.setString(5, instrutor.getTelefone());
                pstmt.setString(6, instrutor.getEndereco());

                int insertedRow = pstmt.executeUpdate();

                if (insertedRow > 0) {
                    pstmt.getGeneratedKeys();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public Instrutor buscarPorId(int id) throws SQLException {
        var sql = "SELECT * FROM instrutor WHERE id = ?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);

            var rs = pstmt.executeQuery();

            if(rs.next()){

                return new Instrutor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Instrutor buscarInstrutorPorNome(String nome) throws SQLException {
        var sql = "SELECT * FROM instrutor WHERE nome = ?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, nome);

            var rs = pstmt.executeQuery();
            if(rs.next()){
                Instrutor instrutor = new Instrutor(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        rs.getString("endereco"));
                return instrutor;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Instrutor buscarInstrutorPorEmail(String email) throws SQLException {
        var sql = "SELECT * FROM instrutor WHERE email = ?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);

            var rs = pstmt.executeQuery();
            if(rs.next()){
                Instrutor instrutor = new Instrutor(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        rs.getString("endereco"));
                return instrutor;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Instrutor> listar() throws SQLException {
        ArrayList<Instrutor> instrutores = new ArrayList<>();
        var sql = "SELECT * FROM instrutor";

        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            var rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String telefone = rs.getString("telefone");
                String endereco = rs.getString("endereco");

                Instrutor instrutor = new Instrutor(/*parametros*/);
                instrutores.add(instrutor);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return instrutores;
    }

    public void deletar(int id){
        var sql = "DELETE FROM instrutor WHERE id = ?";

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

    /*
    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void salvar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, cpf, email, senha, telefone, endereco, matricula, plano, instrutor_id, treinamento_id, frequencia_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getCpf());
        stmt.setString(3, aluno.getEmail());
        stmt.setString(4, aluno.getSenha());
        stmt.setString(5, aluno.getTelefone());
        stmt.setString(6, aluno.getEndereco());
        stmt.setString(7, aluno.getMatricula());
        stmt.setString(8, aluno.getPlano());

        if (aluno.getInstrutor() != null) {
            stmt.setInt(9, aluno.getInstrutor().getId());
        } else {
            stmt.setNull(9, Types.INTEGER);
        }

        if (aluno.getTreinamento() != null) {
            stmt.setInt(10, aluno.getTreinamento().getId());
        } else {
            stmt.setNull(10, Types.INTEGER);
        }

        if (aluno.getFrequencia() != null) {
            stmt.setInt(11, aluno.getFrequencia().getId());
        } else {
            stmt.setNull(11, Types.INTEGER);
        }

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idGerado = rs.getInt(1);
            aluno.setId(idGerado);
        }
    }

    @Override
    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE Aluno SET nome = ?, cpf = ?, email = ?, senha = ?, telefone = ?, endereco = ?, " +
                "matricula = ?, plano = ?, instrutor_id = ?, treinamento_id = ?, frequencia_id = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, aluno.getNome());
        stmt.setString(2, aluno.getCpf());
        stmt.setString(3, aluno.getEmail());
        stmt.setString(4, aluno.getSenha());
        stmt.setString(5, aluno.getTelefone());
        stmt.setString(6, aluno.getEndereco());
        stmt.setString(7, aluno.getMatricula());
        stmt.setString(8, aluno.getPlano());
        stmt.setInt(9, aluno.getInstrutor().getId());
        stmt.setInt(10, aluno.getTreinamento().getId());
        stmt.setInt(11, aluno.getFrequencia().getId());
        stmt.setInt(12, aluno.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Aluno WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        //necessario deletar as colunas nas chaves estrangeiras
    }

    @Override
    public Aluno buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Aluno WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            InstrutorDAO instrutorDAO = new InstrutorDAO(conexao);
            Instrutor instrutor = instrutorDAO.buscarPorId(rs.getInt("instrutor_id"));
            TreinamentoDAO treinamentoDAO = new TreinamentoDAO(conexao);
            Treinamento treinamento = treinamentoDAO.buscarPorId(rs.getInt("treinamento_id"));
            FrequenciaDAO frequenciaDAO = new FrequenciaDAO(conexao);
            Frequencia frequencia = frequenciaDAO.buscarPorId(rs.getInt("frequencia_id"));

            Aluno aluno = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("matricula"),
                    rs.getString("plano"),
                    instrutor,
                    treinamento,
                    frequencia);
            return aluno;

            ///Necessario atribuir os Treinos e Frequencias tambem
        }
        return null;
    }

    @Override
    public List<Aluno> listar() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Aluno aluno = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("matricula"),
                    rs.getString("plano")
            );
            alunos.add(aluno);
        }
        return alunos;
    }*/
}
