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

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pjList = new ArrayList<>();

    public void inserir(PessoaJuridica pjCadastro) {
        pjList.add(pjCadastro);
    }

    public void alterar(PessoaJuridica pjMudar) {
        for (int i = 0; i < pjList.size(); i++) {
            if (pjList.get(i).getId() == pjMudar.getId()) {
                pjList.set(i, pjMudar);
                break;
            }
        }
    }

    public void excluir(int id) {
        
        for (PessoaJuridica pjExcluir : pjList) {
            if (pjExcluir.getId() == id) {
                pjList.remove(pjExcluir);
            }
        }
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pjObter : pjList) {
            if (pjObter.getId() == id) {
                return pjObter;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pjList;
    }

    public void persistir(String arquivo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(pjList);
            
            oos.flush();
            fos.close();
            
            System.out.println("Dados de Pessoa Juridica Armazenados .");
        } 
    }

    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(arquivo); 
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            pjList = (ArrayList<PessoaJuridica>) ois.readObject();
            
            ois.close();
            fis.close();
            
            System.out.println("Dados de Pessoa Juridica Recuperados .");
            
        }
    }
}
