package model;

public class ExceptionPessoaJuridicaNaoEncontrada extends Exception{ // Exceção criada para caso de pessoa Juridica não encontrada
    @Override
    public String getMessage() {
        return "PessoaJuridica não encontrada na lista!"; 
    }
}
