package model;

public class ExceptionPessoaFisicaNaoEncontrada extends Exception { // Exceção de pessoa fisica não encontrada
    @Override
    public String getMessage() {
        return "PessoaFisica não encontrada na lista!";
    }
}
