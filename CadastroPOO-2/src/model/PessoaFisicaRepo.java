/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class PessoaFisicaRepo {
    Scanner scanner = new Scanner(System.in);
   private ArrayList<PessoaFisica> pfLista = new ArrayList<>();
     
    
    public void inserir(PessoaFisica pfCadastro){
        pfLista.add(pfCadastro);
        

    }
    
    public void alterar(PessoaFisica pfMudar){
        for (int i = 0; i < pfLista.size();i++){
            if(pfLista.get(i).getId() == pfMudar.getId()){
                pfLista.set(i ,pfMudar);
                break;
            }   
       }   
    }
    
    public void excluir(int id){
        Iterator<PessoaFisica> it = pfLista.iterator();
    while (it.hasNext()) {
        PessoaFisica pessoaFisica = it.next();
        if (pessoaFisica.getId() == id) {
            it.remove();
            break;
        }
    }
    }
    
    public PessoaFisica obter(int id) {
        
        for(PessoaFisica pfObter : pfLista){
            if(pfObter.getId()== id){
              return  pfObter; 
            }else{
                
            }
        }return null;
        
       
    } 
            
    public ArrayList<PessoaFisica> obterTodos(){
        
        return pfLista;
        
    }       
   
    public void persistir(String arquivo) throws IOException{
        
        FileOutputStream fos = new FileOutputStream(arquivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(pfLista);
            oos.flush();
            fos.close();
        }
        System.out.println("Dados de Pessoa Fisica Armazenados .");
    }
    
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException{
        
        try (FileInputStream fisFisica = new FileInputStream(arquivo); 
            ObjectInputStream oisFisica = new ObjectInputStream(fisFisica)) {
            
            pfLista = (ArrayList<PessoaFisica>)oisFisica.readObject();
            
            oisFisica.close();
            fisFisica.close();
            System.out.println("Dados de Pessoa Fisica Recuperados .");
        }
    }
   void incluirPessoaFisica()  throws IOException, ClassNotFoundException {
        
      PessoaFisicaRepo repo = new PessoaFisicaRepo();
        repo.recuperar("pessoas-fisicas.txt");
        
        System.out.println("Insira os dados da pessoa física:");

        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        
       
       boolean duplicado = true;
       
       while(duplicado == true && repo.pfLista.size() > 0){
           
           
           
            for (int i = 0; i < repo.pfLista.size();i++){
                
                if(repo.pfLista.get(i).getId() == id){
                    System.out.println("O ID já está em uso, tente outro ID!");
                    duplicado = true;
                    System.out.print("Id: ");
                    id = Integer.parseInt(scanner.nextLine());
                    break;
                 }else{
                    duplicado = false;
                 }
           } 
       }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        
        String cpf = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        
        
        repo.inserir(new PessoaFisica(id, nome, cpf, idade));
        
        repo.persistir("pessoas-fisicas.txt");
        
        System.out.println("Pessoa física inserida com sucesso.");
        
        
    
   }
   
  public void alterarPessoaFisica() throws IOException, ClassNotFoundException {
      
    PessoaFisicaRepo repo = new PessoaFisicaRepo(); 
    
    repo.recuperar("pessoas-fisicas.txt");
    
    System.out.print("Id da pessoa física: ");
    
    int id = Integer.parseInt(scanner.nextLine());
    
     for (int i = 0; i < repo.pfLista.size();i++){ 
        if(repo.pfLista.get(i).getId() == id){
            
       System.out.println("Pessoa física  encontrada.");
            
        }else{
            System.out.println("Pessoa física não encontrada.");
        }
       
    }
     System.out.println("Dados atuais:");
        
            System.out.println("Id : " + repo.pfLista.get(id-1).getId());
            System.out.println("Nome: " + repo.pfLista.get(id-1).getNome());
            System.out.println("CPF: " + repo.pfLista.get(id-1).getCpf());
            System.out.println("Idade: " + repo.pfLista.get(id-1).getIdade());
            
 System.out.println("Insira os novos dados:");
                
            System.out.println("Id : " + id);
       
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());
        
           repo.alterar(new PessoaFisica(id, nome, cpf, idade));

            System.out.println("Pessoa física alterada com sucesso.");
    
            repo.persistir("pessoas-fisicas.txt");
  }
  public void excluirPessoaFisica() throws IOException, ClassNotFoundException {

    PessoaFisicaRepo repo = new PessoaFisicaRepo();
    repo.recuperar("pessoas-fisicas.txt");

    System.out.print("Id da pessoa física: ");
    int id = Integer.parseInt(scanner.nextLine());

    for (PessoaFisica pessoaFisic : repo.pfLista) {
        if (id == pessoaFisic.getId()) {
            repo.excluir(id);
            System.out.println("Pessoa física excluída com sucesso.");
            break;
        } else {
            System.out.println("Pessoa física não encontrada.");
            break;
        }
    }

    repo.persistir("pessoas-fisicas.txt");
}
  
  
public void obterPessoaFisica() throws IOException, ClassNotFoundException {
    PessoaFisicaRepo repo = new PessoaFisicaRepo();
    
    repo.recuperar("pessoas-fisicas.txt");
    
    System.out.print("Id da pessoa física: ");
    int id = Integer.parseInt(scanner.nextLine());
    
    for (int i = 0; i < repo.pfLista.size();i++){
                
                 if(repo.pfLista.get(i).getId() == id){
                     repo.pfLista.get(i).exibir();
                     break;
                 }else if(repo.pfLista.size()<id){
                     System.out.println("Pessoa física não encontrada.");
                     break;
                 } else {
                 }               
    }
    repo.persistir("pessoas-fisicas.txt");  
    
}

public void obterTodosPessoaFisica() throws IOException, ClassNotFoundException {
    PessoaFisicaRepo repo = new PessoaFisicaRepo();
    
    repo.recuperar("pessoas-fisicas.txt");
    
    for (PessoaFisica pessoaFisica : repo.obterTodos()) {
            pessoaFisica.exibir();
        }   
    
    repo.persistir("pessoas-fisicas.txt");  
    
}



}
    

