package model.domain;

import model.domain.usuarios.Aluno;
import model.domain.usuarios.Gerente;
import model.domain.usuarios.Instrutor;
import model.domain.usuarios.Usuario;

public class UsuarioFactory {
    
    public static Usuario criaUsuario(UsuarioTipo tipo){
        return switch (tipo) {
            case ALUNO -> new Aluno();
            case INSTRUTOR -> new Instrutor();
            case GERENTE -> new Gerente();
            default -> throw new IllegalArgumentException("Tipo de usuário inválido.");
        };
    }
}
