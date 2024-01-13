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
public class PessoaJuridicaRepo {
    Scanner scanner = new Scanner(System.in);
   private ArrayList<PessoaJuridica> pjLista = new ArrayList<>();
    
    public void inserir(PessoaJuridica pjCadastrar){
        pjLista.add(pjCadastrar);   
    }
    
    public void alterar(PessoaJuridica pjMudar){
        for(int i =0; i < pjLista.size();i++){
           if(pjLista.get(i).getId() == pjMudar.getId()){
           pjLista.set(i, pjMudar);
           break;
           } 
        }
    }

    public void excluir(int id){
        Iterator<PessoaJuridica> it = pjLista.iterator();
    while (it.hasNext()) {
        PessoaJuridica pessoaJuridica = it.next();
        if (pessoaJuridica.getId() == id) {
            it.remove();
            break;
        }
    }
    }
    
   public PessoaJuridica obter(int id) {
        for(PessoaJuridica pjObter : pjLista){
            if(pjObter.getId()== id){
                System.out.println(pjObter);
                
            }
        }
        return null;
       
    }  
    
   public ArrayList<PessoaJuridica> obterTodos(){
        return pjLista;
       
   } 
   
   public void persistir(String arquivo)throws IOException {
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(pjLista);
            
            oos.flush();
            fos.close();
            System.out.println("Dados de Pessoa Juridica Armazenados .");
        }
       
   }
   
   public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(arquivo)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                pjLista = (ArrayList<PessoaJuridica>)ois.readObject();
            }
            fis.close();
            System.out.println("Dados de Pessoa Juridica Recuperados .");
        }
   }
   
   public  void incluirPessoaJuridica() throws IOException, ClassNotFoundException {
       
       PessoaJuridicaRepo repo = new PessoaJuridicaRepo();
        System.out.println("Insira os dados da pessoa Juridica:");
        
        repo.recuperar("pessoas-juridicas.txt");
        
        System.out.print("Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        
       boolean duplicado = true;
       
       while(duplicado == true && repo.pjLista.size() > 0){
           
            for (int i = 0; i < repo.pjLista.size();i++){
                
                 if(repo.pjLista.get(i).getId() == id){
                 System.out.println("O ID já está em uso, tente outro ID!");
                 duplicado = true;
                 System.out.print("Id: ");
                 id = Integer.parseInt(scanner.nextLine());
                 break;
                 }else{
                 duplicado=false;
                 }
            }
       }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();

        repo.inserir( new PessoaJuridica(id, nome, cnpj));
        
        repo.persistir("pessoas-juridicas.txt");
        
        System.out.println("Pessoa juridica inserida com sucesso.");
}
   public void alterarPessoaJuridica() throws IOException, ClassNotFoundException {
       
    PessoaJuridicaRepo repo = new PessoaJuridicaRepo();
    
    repo.recuperar("pessoas-juridicas.txt");
    
    System.out.print("Id da pessoa jurídica: ");
    
    int id = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < repo.pjLista.size();i++){ 
        if(repo.pjLista.get(i).getId() == id){
            
            System.out.println("Pessoa física  encontrada.");
            
        }else{
            System.out.println("Pessoa física não encontrada.");
        }
       
    }
         System.out.println("Dados atuais:");
        
        System.out.println("Id : " + repo.pjLista.get(id-1).getId());
            System.out.println("Nome: " + repo.pjLista.get(id-1).getNome());
            System.out.println("CPF: " + repo.pjLista.get(id-1).getCnpj());
            
        System.out.println("Insira os novos dados:");
                
        System.out.println("Id : " + id);
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CNPJ: ");
        
        String cnpj = scanner.nextLine();
        
        repo.alterar(new PessoaJuridica(id, nome, cnpj));
                  
        System.out.println("Pessoa juridica não encontrada.");
        
        repo.persistir("pessoas-juridicas.txt");
    
  }
   
   public void excluirPessoaJuridica() throws IOException, ClassNotFoundException {

    PessoaJuridicaRepo repo = new PessoaJuridicaRepo();
    repo.recuperar("pessoas-juridicas.txt");

    System.out.print("Id da pessoa juridica: ");
    int id = Integer.parseInt(scanner.nextLine());

    for (PessoaJuridica pj : repo.pjLista) {
        if (id == pj.getId()) {
            repo.excluir(id);
            System.out.println("Pessoa juridica excluída com sucesso.");
            break;
        } else {
            System.out.println("Pessoa juridica não encontrada.");
            break;
        }
    }

    repo.persistir("pessoas-juridicas.txt");
}
 public void obterPessoaJuridica() throws IOException, ClassNotFoundException {
    PessoaJuridicaRepo repo = new PessoaJuridicaRepo();
    
    repo.recuperar("pessoas-juridicas.txt");
    
    System.out.print("Id da pessoa juridica: ");
    int id = Integer.parseInt(scanner.nextLine());
    
         for (int i = 0; i < repo.pjLista.size();i++){
                
                 if(repo.pjLista.get(i).getId() == id){
                     repo.pjLista.get(i).exibir();
                     break;
                 }else if(repo.pjLista.size()<id){
                     System.out.println("Pessoa física não encontrada.");
                     break;
                 } else {
                 }               
    }
    
    repo.persistir("pessoas-juridicas.txt");   
}  
 
 public void obterTodosPessoaJuridica() throws IOException, ClassNotFoundException {
    PessoaJuridicaRepo repo = new PessoaJuridicaRepo();
    
    repo.recuperar("pessoas-juridicas.txt");
    
    for (PessoaJuridica pessoaJuridica : repo.obterTodos()) {
            pessoaJuridica.exibir();
        }   
    
    repo.persistir("pessoas-juridicas.txt");  
    
}

 
}