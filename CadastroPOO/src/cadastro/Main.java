package cadastro;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {

    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Anma", "11111111111", 25);
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
        repo1.inserir(pessoaFisica1);
        repo1.inserir(pessoaFisica2);

        String nomeArquivoPessoasFisicas = "pessoasfisicas.dat";
        try {
            repo1.persistir(nomeArquivoPessoasFisicas);
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (Exception e) {
            System.out.println("Erro ao persistir os dados de Pessoa Física: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        try {
            repo2.recuperar(nomeArquivoPessoasFisicas);
            System.out.println("Dados de Pessoa Física Recuperados:");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                System.out.println("Id: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
            }
        } catch (Exception e) {
            System.out.println("Erro ao recuperar os dados de Pessoa Física: " + e.getMessage());
        }


        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();


        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(3, "xptro sales", "33333333333333");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(4, "xpto solutions", "4444444444444");
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);


        String nomeArquivoPessoasJuridicas = "pessoasjuridicas.dat";
        try {
            repo3.persistir(nomeArquivoPessoasJuridicas);
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
        } catch (Exception e) {
            System.out.println("Erro ao persistir os dados de Pessoa Jurídica: " + e.getMessage());
        }

        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();


        try {
            repo4.recuperar(nomeArquivoPessoasJuridicas);
            System.out.println("Dados de Pessoa Jurídica Recuperados:");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                System.out.println("Id: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CNPJ: " + pessoa.getCnpj());
            }
        } catch (Exception e) {
            System.out.println("Erro ao recuperar os dados de Pessoa Jurídica: " + e.getMessage());
        }
    }
}

