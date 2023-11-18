package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo { // Repositório de PessoaFisica
    
    private ArrayList<PessoaFisica> lista; // ArrayList de PessoaFisica
    
   public PessoaFisicaRepo(){ // Método construtor
       lista = new ArrayList<PessoaFisica>();
   }
    
   public void inserir(PessoaFisica pessoaFisica){ // Inserir pessoaFisica
       lista.add(pessoaFisica);
   }
   
   public void alterar(PessoaFisica pessoaFisica){ // Alterar pessoaFisica por id
       for(PessoaFisica pessoaFisica2 : lista){
           if(pessoaFisica2.getId() == pessoaFisica.getId()){
              pessoaFisica2.setId(pessoaFisica.getId());
              pessoaFisica2.setNome(pessoaFisica.getNome());
              pessoaFisica2.setIdade(pessoaFisica.getIdade());
              pessoaFisica2.setCpf(pessoaFisica.getCpf());
           }
       }
   }
   
   public void excluir(int id){ // excluir por id
       for(int i = 0; i < lista.size(); i++){
           if(lista.get(i).getId() == id){
                lista.remove(i);
           }
       }
   }
   
   public PessoaFisica obter(int id) throws ExceptionPessoaFisicaNaoEncontrada{ // Obter pessoaFisica por id
       for(int i = 0; i < lista.size(); i++){
           if(lista.get(i).getId() == id){
               return lista.get(i);
           }
       }
       
       throw new ExceptionPessoaFisicaNaoEncontrada();
   }
   
   public ArrayList<PessoaFisica> obterTodos(){ // Obter todas as pessoas fisicas
       return lista;
   }
   
   public void persistir(String arquivo) { // Salvar como arquivo binário
       String temp = arquivo + ".fisica.bin";
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(temp));
            for (PessoaFisica pessoaFisica : lista) {
                file.writeObject(pessoaFisica);
            }
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
   }
   
   public ArrayList<PessoaFisica> recuperar(String arquivo) { // Recuperar arquivo binário
        lista = new ArrayList<PessoaFisica>();
        String temp = arquivo + ".fisica.bin";
        try {
            PessoaFisica pessoaFisica = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(temp));
            do {
                pessoaFisica = (PessoaFisica) file.readObject();
                if (pessoaFisica != null) {
                    lista.add(pessoaFisica);
                }
            } while (pessoaFisica != null);
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
   }
}
