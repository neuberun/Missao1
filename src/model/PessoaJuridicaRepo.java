package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo { // PessoaJuridica repositorio
    
   private ArrayList<PessoaJuridica> lista; // Lista de pessoa juridica
    
   public PessoaJuridicaRepo(){ // Metodo construtor
       lista = new ArrayList<PessoaJuridica>();
   }
    
   public void inserir(PessoaJuridica pessoaJuridica){ // Inserir 
       lista.add(pessoaJuridica);
   }
   
  public void alterar(PessoaJuridica pessoaJuridica){ // Alterar
       for(PessoaJuridica pessoaJuridica2 : lista){
           if(pessoaJuridica2.getId() == pessoaJuridica.getId()){
              pessoaJuridica2.setId(pessoaJuridica.getId());
              pessoaJuridica2.setNome(pessoaJuridica.getNome());
              pessoaJuridica2.setCnpj(pessoaJuridica.getCnpj());
           }
       }
   }
   
   public void excluir(int id){ // Excluir por id
       for(int i = 0; i < lista.size(); i++){
           if(lista.get(i).getId() == id){
                lista.remove(i);
           }
       }
   }
   
   public PessoaJuridica obter(String nome) throws ExceptionPessoaJuridicaNaoEncontrada{ // Obter por nome
       for(int i = 0; i < lista.size(); i++){
           if(lista.get(i).getNome().equals(nome)){
               return lista.get(i);
           }
       }
       
       throw new ExceptionPessoaJuridicaNaoEncontrada();
   }
   
   public ArrayList<PessoaJuridica> obterTodos(){ // obeter todos
       return lista;
   }
   
   public void persistir(String arquivo) { // Persistir em arquivo binário
       String temp = arquivo + ".juridica.bin";
       try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(temp));
            for (PessoaJuridica pessoaJuridica : lista) {
                file.writeObject(pessoaJuridica);
            }
            file.close();
       } catch (IOException e) {
            System.out.println(e.getMessage());
       }
   }
   
    public ArrayList<PessoaJuridica> recuperar(String arquivo) { // Recuperar do arquivo binario
        lista = new ArrayList<PessoaJuridica>();
        String temp = arquivo + ".juridica.bin";
        
        try {
            PessoaJuridica pessoaJuridica = null;
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(temp));
            do {
                pessoaJuridica = (PessoaJuridica) file.readObject();
                if (pessoaJuridica != null) {
                    lista.add(pessoaJuridica);
                }
            } while (pessoaJuridica != null);
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
   }
}

