package cadastropoo;

import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) { // Método main
        Scanner scan = new Scanner(System.in); // Scanner que recebe a entrada
        PessoaFisicaRepo pessoasFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoasJuridicaRepo = new PessoaJuridicaRepo();
 
        int opc = -1;
        String opc2;
        
        while (opc != 0) {
            System.out.println("=================================");
            System.out.println("1 - Incluir Pessoa" + "\n" + "2 - Alterar Pessoa" + "\n" + "3 - Excluir Pessoa" + "\n"
                    +  "4 - Buscar pelo Id" + "\n" + "5 - Exibir Todos" + "\n" + "6 - Persistir Dados" + "\n" + 
                    "7 - Recuperar Dados" + "\n" + "0 - Finalizar Programa");
            System.out.println("=================================");
            opc = scan.nextInt();
            scan.nextLine();
            if(opc == 0) {
            	break;
            }
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
            opc2 = scan.next();
            scan.nextLine();
            switch(opc) {
                case 1: // Inclui Pessoa
                    if(opc2.equals("F")){
                            System.out.print("ID: ");
                            int id2 = scan.nextInt(); 
                            scan.nextLine();
                            System.out.print("NOME: ");
                            String nome = scan.nextLine();
                            scan.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scan.nextLine();
                            scan.nextLine();
                            System.out.print("IDADE: ");
                            int idade = scan.nextInt();
                            scan.nextLine();
                            pessoasFisicaRepo.inserir(new PessoaFisica(id2, nome, cpf, idade));
                    } else if(opc2.equals("J")){
                            System.out.print("ID: ");
                            int id2 = scan.nextInt();
                            scan.nextLine();
                            System.out.print("NOME: ");
                            String nome = scan.nextLine();
                            scan.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = scan.nextLine();
                            scan.nextLine();
                            pessoasJuridicaRepo.obterTodos().add(new PessoaJuridica(id2, nome, cnpj));
                    }
                    break;
                    
                case 2: // Altera Pessoa
                    if(opc2.equals("F")){
                            System.out.print("ID: ");
                            int id = scan.nextInt();
                            scan.nextLine();
                            System.out.print("NOME: ");
                            String nome = scan.nextLine();
                            scan.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scan.nextLine();
                            scan.nextLine();
                            System.out.print("IDADE: ");
                            int idade = scan.nextInt();
                            scan.nextLine();
                            pessoasFisicaRepo.alterar(new PessoaFisica(id, nome, cpf, idade));
                    } else if(opc2.equals("J")){
                            System.out.print("ID: ");
                            int id = scan.nextInt();
                            scan.nextLine();
                            System.out.print("NOME: ");
                            String nome = scan.nextLine();
                            scan.nextLine();
                            System.out.print("CNPJ: ");
                            String cnpj = scan.nextLine();
                            scan.nextLine();
                            pessoasJuridicaRepo.alterar(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
   
                case 3: //Exclui Pessoa
                    System.out.println("Digite o ID...");
                    int id = scan.nextInt();
                    scan.nextLine();
                    if(opc2.equals("F")){
                        for(int i = 0; i < pessoasFisicaRepo.obterTodos().size(); i++){
                            if(pessoasFisicaRepo.obterTodos().get(i).getId() == id){
                                pessoasFisicaRepo.excluir(id);
                            }
                        }    
                    } else if(opc2.equals("J")){
                        for(int i = 0; i < pessoasJuridicaRepo.obterTodos().size(); i++){
                            if(pessoasJuridicaRepo.obterTodos().get(i).getId() == id){
                                pessoasJuridicaRepo.excluir(id);
                            }
                        } 
                    }
                    break;
                    
                case 4: // Busca pelo Id
                    System.out.println("Digite o ID...");
                    int id1 = scan.nextInt();
                    scan.nextLine();
                    if(opc2.equals("F")){
                        for(PessoaFisica pessoaFisica2 : pessoasFisicaRepo.obterTodos()){
                            if(pessoaFisica2.getId() == id1){
                                System.out.println("--------------");
                                System.out.println( "NOME: " + pessoaFisica2.getNome() + "\n" + "CPF: " +
                                pessoaFisica2.getCpf() + "\n" + "IDADE: " + pessoaFisica2.getIdade());
                            }
                        }    
                    } else if(opc2.equals("J")){
                        for(PessoaJuridica pessoaJuridica2 : pessoasJuridicaRepo.obterTodos()){
                            if(pessoaJuridica2.getId() == id1){
                                System.out.println("--------------");
                                System.out.println( "NOME: " + pessoaJuridica2.getNome() + "\n" + "CNPJ: " +
                                pessoaJuridica2.getCnpj());
                            }
                        }
                    }
                    break;
                    
                case 5: // Exibe Todos
                    if(opc2.equals("F")){
                        System.out.println("-------[ CADASTRO DE PESSOAS FISICAS ]-------");
                        for(PessoaFisica pessoaFisica2 : pessoasFisicaRepo.obterTodos()) {
                            System.out.println("--------------");
                            System.out.println( "NOME: " + pessoaFisica2.getNome() + "\n" + "CPF: " +
                                    pessoaFisica2.getCpf() + "\n" + "IDADE: " + pessoaFisica2.getIdade());
                        }
                    } else if(opc2.equals("J")){
                        System.out.println("-------[ CADASTRO DE PESSOAS JURIDICA ]-------");
                        for(PessoaJuridica pessoaJuridica2 : pessoasJuridicaRepo.obterTodos()){
                            System.out.println("--------------");
                            System.out.println( "NOME: " + pessoaJuridica2.getNome() + "\n" + "CNPJ: " +
                            pessoaJuridica2.getCnpj());
                        }
                    }
                    break;
                    
                case 6: //Persistir
                    System.out.println("Digite o nome do arquivo...");
                    String arquivo = scan.nextLine();
                    scan.nextLine();
                    if(opc2.equals("F")){
                        pessoasFisicaRepo.persistir(arquivo);
                    }else if(opc2.equals("J")){
                        pessoasJuridicaRepo.persistir(arquivo);
                    }
                    break;
                    
                case 7: // Recuperar
                    System.out.println("Digite o nome do arquivo...");
                    String arquivo2 = scan.nextLine();
                    scan.nextLine();
                    if(opc2.equals("F")){
                        pessoasFisicaRepo.recuperar(arquivo2);
                    }else if(opc2.equals("J")){
                        pessoasJuridicaRepo.recuperar(arquivo2);
                    }
            }
        }
        scan.close();
    }
}