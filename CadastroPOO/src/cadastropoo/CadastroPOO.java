/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author usuario
 */
public class CadastroPOO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
    // Instanciar um repositório de pessoas físicas
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        // Adicionar duas pessoas físicas
        repo1.inserir(new PessoaFisica(1, "Ana", "11111111111", 25));
        repo1.inserir(new PessoaFisica(2, "Carlos", "22222222222", 52));

        // Persistir as pessoas físicas
        repo1.persistir("pessoas-fisicas.txt");

        // Instanciar outro repositório de pessoas físicas
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        // Recuperar as pessoas físicas
        repo2.recuperar("pessoas-fisicas.txt");
         repo2.alterar(new PessoaFisica(1,"samir","111",37));
          // Adicionar duas pessoas físicas
       
        
        //Exibir os dados das pessoas físicas recuperadas
        for (PessoaFisica pessoaFisica : repo2.obterTodos()) {
        pessoaFisica.exibir();
        }

        // Instanciar um repositório de pessoas jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        // Adicionar duas pessoas jurídicas
        repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33333333333333"));
        repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44444444444444"));

        // Persistir as pessoas jurídicas
        repo3.persistir("pessoas-juridicas.txt");

        // Instanciar outro repositório de pessoas jurídicas
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        // Recuperar as pessoas jurídicas
        repo4.recuperar("pessoas-juridicas.txt");

        // Exibir os dados das pessoas jurídicas recuperadas
        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
             repo1.obter(1);
            pessoaJuridica.exibir();
            
        }
    }
}
