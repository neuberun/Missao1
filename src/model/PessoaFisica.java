package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable { // PessoaFisica extend de Pessoa e implementa Serializable
    
    private String cpf;
    private int idade;
    
    public PessoaFisica(int id, String nome, String cpf, int idade){ // Método construtor
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() { // Métodos get e set
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String exibir() { // Retorna informações de exibir
        return super.exibir() + "Cpf: " + cpf + "/n" + "Idade: " + idade + "/n";
    }
}
