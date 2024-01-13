/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/**
 *
 * @author usuario
 */
public class OpcaoRepo extends Opcao{
    
Scanner scanner = new Scanner(System.in);

   
    
public void escolherOpcao() throws IOException, ClassNotFoundException{
      
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Obter pelo id");
            System.out.println("5 - Obter todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");

            setOpcao(Integer.parseInt(scanner.nextLine()));

            switch (getOpcao()) {
                case 1 -> incluir(scanner);
                case 2 -> alterar(scanner);
                case 3 -> excluir(scanner);
                case 4 -> obter(scanner);
                case 5 -> obterTodos(scanner);
                case 6 -> salvar(scanner);
                case 7 -> recuperar(scanner);
                case 0 -> System.out.println("""
                                             Fim da execu\u00e7\u00e3o.
                                             Obrigado por usar nosso sistema!""");
                default -> System.out.println("Opção inválida.");
            }
        } while (getOpcao() != 0 );
    }

public void tipo() throws IOException{
    
 System.out.println("Selecione o tipo da entidade:");
        System.out.println("F - Pessoa Física");
        System.out.println("J - Pessoa Jurídica");

       
      String d = scanner.nextLine();

        setTipo(null);
      
        switch (d) {
        case "F", "f" -> setTipo("F");
        case "J", "j" -> setTipo("J");
        default -> System.out.println("Opção inválida.");
    }
    
}

public void incluir(Scanner scanner) throws IOException, ClassNotFoundException {
      
     
    
    this.tipo();
    if("F".equals(getTipo())){
       PessoaFisicaRepo repo = new PessoaFisicaRepo();
       repo.incluirPessoaFisica();
    } else if("J".equals(getTipo())) {
        PessoaJuridicaRepo repo =new PessoaJuridicaRepo();
        repo.incluirPessoaJuridica();
    }
}

 public void alterar(Scanner scanner) throws IOException, ClassNotFoundException {
   
    this.tipo();
   if("F".equals(getTipo())){
        PessoaFisicaRepo repo = new PessoaFisicaRepo();
        repo.alterarPessoaFisica();
    } else if("J".equals(getTipo())) {
        PessoaJuridicaRepo repo =new PessoaJuridicaRepo();
        repo.alterarPessoaJuridica();
       
    }
 }
 
 public void excluir(Scanner scanner) throws IOException, ClassNotFoundException {
   
    this.tipo();
   if("F".equals(getTipo())){
        PessoaFisicaRepo repo = new PessoaFisicaRepo();
        repo.excluirPessoaFisica();
    } else if("J".equals(getTipo())) {
        PessoaJuridicaRepo repo =new PessoaJuridicaRepo();
        repo.excluirPessoaJuridica();   
    }
}
 
 public void obter(Scanner scanner) throws IOException, ClassNotFoundException {
   
    this.tipo();
   if("F".equals(getTipo())){
        PessoaFisicaRepo repo = new PessoaFisicaRepo();
        repo.obterPessoaFisica();
    } else if("J".equals(getTipo())) {
        PessoaJuridicaRepo repo =new PessoaJuridicaRepo();
        repo.obterPessoaJuridica();   
    }
}

public void obterTodos(Scanner scanner) throws IOException, ClassNotFoundException {
   
    this.tipo();
   if("F".equals(getTipo())){
        PessoaFisicaRepo repo = new PessoaFisicaRepo();
        repo.obterTodosPessoaFisica();
    } else if("J".equals(getTipo())) {
        PessoaJuridicaRepo repo =new PessoaJuridicaRepo();
        repo.obterTodosPessoaJuridica();   
    }
}
 
   public void salvar(Scanner scanner) throws IOException, ClassNotFoundException {

    System.out.print("Informe o prefixo do arquivo pessoa fisica: ");
    String prefixo = scanner.nextLine() + ".fisica.bin";

    FileOutputStream fosFisica = new FileOutputStream(prefixo + ".fisica.bin");
    ObjectOutputStream oosFisica = new ObjectOutputStream(fosFisica);
    
     System.out.print("Informe o prefixo do arquivo pessoa juridica: ");
    String prefixo1 = scanner.nextLine() + ".juridica.bin";
    
    FileOutputStream fosJuridica = new FileOutputStream(prefixo1 + ".juridica.bin");
    ObjectOutputStream oosJuridica = new ObjectOutputStream(fosJuridica);

    try {
        PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();
        
        pfRepo.recuperar("pessoas-fisicas.txt"); 
        pfRepo.persistir(prefixo );
        
        
         pfRepo.recuperar("pessoas-juridicas.txt");
         pjRepo.persistir(prefixo1 );
        

        System.out.println("Dados salvos com sucesso!");
    } catch (IOException e) {
        System.out.println("Erro ao salvar os dados: " + e.getMessage());
    } finally {
        oosFisica.close();
        fosFisica.close();
        oosJuridica.close();
        fosJuridica.close();
    }

   }
    public void recuperar(Scanner scanner) throws IOException, ClassNotFoundException {

    System.out.print("Informe o prefixo do arquivo pessoa fisica: ");
    String prefixo = scanner.nextLine() + ".fisica.bin";
  
    FileInputStream fisFisica = new FileInputStream( prefixo );
    ObjectInputStream oisFisica = new ObjectInputStream(fisFisica);
    
    System.out.print("Informe o prefixo do arquivo pessoa juridica: ");
    String prefixo1 = scanner.nextLine() + ".juridica.bin";
    
    FileInputStream fisJuridica = new FileInputStream(prefixo1 );
    ObjectInputStream oisJuridica = new ObjectInputStream(fisJuridica);

   try {
       
        
   
   
   PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
   pfRepo.recuperar(prefixo);
    for (PessoaFisica pessoaFisica : pfRepo.obterTodos()) {
            pessoaFisica.exibir();
    }
    
   
    PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();
    pjRepo.recuperar(prefixo1);
    for (PessoaJuridica pessoaJuridica : pjRepo.obterTodos()) {
            pessoaJuridica.exibir();
    }
         System.out.println("Dados recuperados com sucesso!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
    } finally {
        oisFisica.close();
        fisFisica.close();
        oisJuridica.close();
        fisJuridica.close();
    }
}

  
}
    
   
