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
public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    public PessoaFisica() {
    }
    
    
    
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.setCpf(cpf);
        this.setIdade(idade);
        
    }


    public String getCpf() {
        return cpf;
    }

    public final void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public final void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void exibir() {
        super.exibir(); 
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + getIdade());
    }
     
}
