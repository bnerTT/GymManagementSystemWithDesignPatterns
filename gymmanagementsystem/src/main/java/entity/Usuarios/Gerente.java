package entity.Usuarios;

import jakarta.persistence.Entity;

import java.util.ArrayList;

@Entity
public class Gerente extends Usuario {
    private String departamento;

    public Gerente(int id, String nome, String cpf, String email, String senha, String endereco, String telefone, String departamento) {
        super(id, nome, cpf, email, senha, endereco, telefone);
        this.departamento = departamento;
    }

    public Gerente() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "departamento='" + departamento + '\'' +
                '}';
    }
}
