
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
class Pessoa implements Serializable {
   private int id;
    private String nome;
    
    public Pessoa() {
    }
   
   public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
     public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
  public void exibir(){
       System.out.println("ID: " + getId());
       System.out.println("Nome: " + getNome());
   }
   
}
