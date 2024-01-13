/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pfList = new ArrayList<>();

    public void inserir(PessoaFisica pfCadastro) {
        pfList.add(pfCadastro);
    }

    public void alterar(PessoaFisica pfMudar) {
     
        for (int i = 0; i < pfList.size(); i++) {
            if (pfList.get(i).getId() == pfMudar.getId()) {
                pfList.set(i, pfMudar);
                break;
            }
        }
    }

    public void excluir(int id) {
        
        for (PessoaFisica pfExcuir : pfList) {
            if (pfExcuir.getId() == id) {
                pfList.remove(pfExcuir);
                
            }
        }
      
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pfObter : pfList) {
            if (pfObter.getId() == id) {
                return pfObter;
                
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pfList;
    }

    public void persistir(String arquivo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(pfList);
            
            oos.flush();
            fos.close();
            
            System.out.println("Dados de Pessoa Fisica Armazenados .");
        }
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(arquivo); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            pfList = (ArrayList<PessoaFisica>) ois.readObject();
            
            ois.close();
            fis.close();
            
            System.out.println("Dados de Pessoa Fisica Recuperados .");
        }
    }
}

