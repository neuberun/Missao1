package model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable{ // PessoaJuridica herda de Pessoa e implementa a interface Serializable
    
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String cnpj){ // Método construtor
        super(id, nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() { // Métodos get e set
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String exibir(){ // Retorna informações de PessoJuridica
        return super.exibir() + "Cnpj: " + cnpj + "/n";
    }
}
