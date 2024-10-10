package model;

import model.dao.AlunoDAO;
import model.dao.FrequenciaDAO;
import model.dao.GerenteDAO;
import model.domain.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {







        /*Gerente gerente = new Gerente(
                "Jackson",        // nome
                "123.456.789-00",    // cpf
                "joao@empresa.com",  // email
                "senha123",          // senha
                "(11) 98765-4321",   // telefone
                "Rua Exemplo, 123",  // endereco
                "Recursos Humanos"   // departamento
        );

        GerenteDAO gerenteDAO = new GerenteDAO();
        ///gerenteDAO.salvar(gerente);
        ArrayList<Gerente> gerentes = gerenteDAO.listar();
        System.out.println(gerentes.size());

        FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

        Frequencia frequencia = frequenciaDAO.buscarFrequenciaPorId(3);
        System.out.println(frequencia);

        LocalDate data1 = LocalDate.now();
        LocalDate data2 = LocalDate.now();
        LocalDate data3 = LocalDate.now();

        ///List<LocalDate> frequenciaLista = new ArrayList<>();

        /*Frequencia frequencia = new Frequencia(3);
        frequencia.getFrequencia().add(data1);
        frequencia.getFrequencia().add(data2);
        frequencia.getFrequencia().add(data3);
        frequenciaDAO.salvar(frequencia);
        frequenciaDAO.inserirDatas(frequencia.getId(), frequencia.getFrequencia());
        */
    }

}
