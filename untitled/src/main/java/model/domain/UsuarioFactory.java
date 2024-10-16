package model.domain;

public class UsuarioFactory {
    
    public static Usuario criaUsuario(UsuarioTipo tipo){
        switch(tipo){
            case ALUNO:
                return new Aluno();
            case INSTRUTOR:
                return new Instrutor();
            case GERENTE:
                return new Gerente();
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido.");
        }
    }
}
