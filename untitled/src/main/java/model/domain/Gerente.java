package model.domain;

public class Gerente extends Usuario{
    private String departamento;

    public Gerente(String nome, String cpf, String email, String senha, String telefone, String endereco, String departamento) {
        super(nome, cpf, email, senha, telefone, endereco);
        this.departamento = departamento;
    }

    public Gerente(int id, String nome, String cpf, String email, String senha, String telefone, String endereco, String departamento) {
        super(id, nome, cpf, email, senha, telefone, endereco);
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
