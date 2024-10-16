package model.dao;

import model.database.DB;
import model.domain.Gerente;
import model.domain.Usuario;
import model.domain.UsuarioFactory;
import model.domain.UsuarioTipo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GerenteDAO implements GenericaDAO<Gerente>{

    public void salvar(Gerente gerente) throws SQLException {
        var sql = "INSERT INTO gerente(nome, cpf, email, senha, telefone, endereco, departamento)"
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(var conn = DB.connect()){
            assert conn != null;

            try(var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                pstmt.setString(1, gerente.getNome());
                pstmt.setString(2, gerente.getCpf());
                pstmt.setString(3, gerente.getEmail());
                pstmt.setString(4, gerente.getSenha());
                pstmt.setString(5, gerente.getTelefone());
                pstmt.setString(6, gerente.getEndereco());
                pstmt.setString(7, gerente.getDepartamento());

                int insertedRow = pstmt.executeUpdate();

                if (insertedRow > 0) {
                    pstmt.getGeneratedKeys();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void editar(int idGerente, Gerente gerente) throws SQLException {
        var sql = "UPDATE gerente SET nome=?, cpf=?, email=?, senha=?, telefone=?, endereco=?, departamento=? WHERE id=?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, gerente.getNome());
            pstmt.setString(2, gerente.getCpf());
            pstmt.setString(3, gerente.getEmail());
            pstmt.setString(4, gerente.getSenha());
            pstmt.setString(5, gerente.getTelefone());
            pstmt.setString(6, gerente.getEndereco());
            pstmt.setString(7, gerente.getDepartamento());
            pstmt.setInt(8, idGerente);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Gerente buscarPorId(int id) throws SQLException {
        var sql = "SELECT * FROM gerente WHERE id = ?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);

            var rs = pstmt.executeQuery();

            if(rs.next()){

                Usuario gerente = UsuarioFactory.criaUsuario(UsuarioTipo.GERENTE);
                gerente.setId(rs.getInt("id"));
                gerente.setNome(rs.getString("nome"));
                gerente.setCpf(rs.getString("cpf"));
                gerente.setEmail(rs.getString("email"));
                gerente.setSenha(rs.getString("senha"));
                gerente.setTelefone(rs.getString("telefone"));
                gerente.setEndereco(rs.getString("endereco"));
                ((Gerente) gerente).setDepartamento(rs.getString("departamento"));
                return ((Gerente) gerente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Gerente buscarGerentePorNome(String nome) throws SQLException {
        var sql = "SELECT * FROM gerente WHERE nome = ?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, nome);

            var rs = pstmt.executeQuery();
            if(rs.next()){
                Usuario gerente = UsuarioFactory.criaUsuario(UsuarioTipo.GERENTE);
                gerente.setId(rs.getInt("id"));
                gerente.setNome(rs.getString("nome"));
                gerente.setCpf(rs.getString("cpf"));
                gerente.setEmail(rs.getString("email"));
                gerente.setSenha(rs.getString("senha"));
                gerente.setTelefone(rs.getString("telefone"));
                gerente.setEndereco(rs.getString("endereco"));
                ((Gerente) gerente).setDepartamento(rs.getString("departamento"));
                return ((Gerente) gerente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Gerente buscarGerentePorEmail(String email) throws SQLException {
        var sql = "SELECT * FROM gerente WHERE email = ?";
        try(var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, email);

            var rs = pstmt.executeQuery();
            if(rs.next()){
                Usuario gerente = UsuarioFactory.criaUsuario(UsuarioTipo.GERENTE);
                gerente.setId(rs.getInt("id"));
                gerente.setNome(rs.getString("nome"));
                gerente.setCpf(rs.getString("cpf"));
                gerente.setEmail(rs.getString("email"));
                gerente.setSenha(rs.getString("senha"));
                gerente.setTelefone(rs.getString("telefone"));
                gerente.setEndereco(rs.getString("endereco"));
                ((Gerente) gerente).setDepartamento(rs.getString("departamento"));
                return ((Gerente) gerente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Gerente> listar() throws SQLException {
        ArrayList<Gerente> gerentes = new ArrayList<>();
        var sql = "SELECT * FROM gerente";

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
                String departamento = rs.getString("departamento");

                Usuario gerente = UsuarioFactory.criaUsuario(UsuarioTipo.GERENTE);
                gerente.setId(id);
                gerente.setNome(nome);
                gerente.setCpf(cpf);
                gerente.setEmail(email);
                gerente.setSenha(senha);
                gerente.setTelefone(telefone);
                gerente.setEndereco(endereco);
                ((Gerente) gerente).setDepartamento(departamento);
                gerentes.add((Gerente)gerente);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return gerentes;
    }

    public void deletar(int id){
        var sql = "DELETE FROM gerente WHERE id = ?";

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
    public gerenteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void salvar(gerente gerente) throws SQLException {
        String sql = "INSERT INTO gerente (nome, cpf, email, senha, telefone, endereco, matricula, plano, gerente_id, treinamento_id, frequencia_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, gerente.getNome());
        stmt.setString(2, gerente.getCpf());
        stmt.setString(3, gerente.getEmail());
        stmt.setString(4, gerente.getSenha());
        stmt.setString(5, gerente.getTelefone());
        stmt.setString(6, gerente.getEndereco());
        stmt.setString(7, gerente.getMatricula());
        stmt.setString(8, gerente.getPlano());

        if (gerente.getGerente() != null) {
            stmt.setInt(9, gerente.getGerente().getId());
        } else {
            stmt.setNull(9, Types.INTEGER);
        }

        if (gerente.getTreinamento() != null) {
            stmt.setInt(10, gerente.getTreinamento().getId());
        } else {
            stmt.setNull(10, Types.INTEGER);
        }

        if (gerente.getFrequencia() != null) {
            stmt.setInt(11, gerente.getFrequencia().getId());
        } else {
            stmt.setNull(11, Types.INTEGER);
        }

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idGerado = rs.getInt(1);
            gerente.setId(idGerado);
        }
    }

    @Override
    public void atualizar(gerente gerente) throws SQLException {
        String sql = "UPDATE gerente SET nome = ?, cpf = ?, email = ?, senha = ?, telefone = ?, endereco = ?, " +
                "matricula = ?, plano = ?, gerente_id = ?, treinamento_id = ?, frequencia_id = ? WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, gerente.getNome());
        stmt.setString(2, gerente.getCpf());
        stmt.setString(3, gerente.getEmail());
        stmt.setString(4, gerente.getSenha());
        stmt.setString(5, gerente.getTelefone());
        stmt.setString(6, gerente.getEndereco());
        stmt.setString(7, gerente.getMatricula());
        stmt.setString(8, gerente.getPlano());
        stmt.setInt(9, gerente.getGerente().getId());
        stmt.setInt(10, gerente.getTreinamento().getId());
        stmt.setInt(11, gerente.getFrequencia().getId());
        stmt.setInt(12, gerente.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM gerente WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        //necessario deletar as colunas nas chaves estrangeiras
    }

    @Override
    public gerente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM gerente WHERE id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            GerenteDAO gerenteDAO = new GerenteDAO(conexao);
            Gerente gerente = gerenteDAO.buscarPorId(rs.getInt("gerente_id"));
            TreinamentoDAO treinamentoDAO = new TreinamentoDAO(conexao);
            Treinamento treinamento = treinamentoDAO.buscarPorId(rs.getInt("treinamento_id"));
            FrequenciaDAO frequenciaDAO = new FrequenciaDAO(conexao);
            Frequencia frequencia = frequenciaDAO.buscarPorId(rs.getInt("frequencia_id"));

            gerente gerente = new gerente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getString("matricula"),
                    rs.getString("plano"),
                    gerente,
                    treinamento,
                    frequencia);
            return gerente;

            ///Necessario atribuir os Treinos e Frequencias tambem
        }
        return null;
    }

    @Override
    public List<gerente> listar() throws SQLException {
        List<gerente> gerentes = new ArrayList<>();
        String sql = "SELECT * FROM gerente";
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            gerente gerente = new gerente(
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
            gerentes.add(gerente);
        }
        return gerentes;
    }*/
}
