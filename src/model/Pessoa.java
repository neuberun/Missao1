package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version configurado para gerar id para salvar e ser enviado para o banco
    private int id;
    private String nome;
    
    public Pessoa(int id, String nome){ // Método construtor
        this.id = id;
        this.nome = nome;
    }

    public int getId() { // Métodos get e set de id
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String exibir(){ // Retorna as informações de exibir
        return "ID: " + id + "/n" + "NOME: " + nome + "/n";
    }
}
