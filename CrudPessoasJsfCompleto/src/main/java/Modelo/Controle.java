/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DAL.PessoaDAO;
import java.util.List;

/**
 *
 * @author rever
 */
public class Controle
{
    public String mensagem;

    public void CadastrarPessoa(List<String> listaDadosPessoa,
            List<List<String>> listaDadosEnderecos)
    {
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarDadosPessoa(listaDadosPessoa);
        if (validacao.mensagem.equals(""))
        {
            pessoa.setId(0);
            pessoa.setNome(listaDadosPessoa.get(1));
            pessoa.setRg(listaDadosPessoa.get(2));
            pessoa.setCpf(listaDadosPessoa.get(3));
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
    
    public Pessoa PesquisarPessoaPorId(String identificacao)
    {
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarIdPessoa(identificacao);
        if (validacao.mensagem.equals(""))
        {
            pessoa.setId(validacao.id);
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa = pessoaDAO.PesquisarPessoaPorId(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
        return pessoa;
    }

    public void ExcluirPessoa(String identificacao)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarIdPessoa(identificacao);
        if (validacao.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(validacao.id);
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.ExcluirPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }

    public void EditarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        PessoaDAO pessoaDAO = new PessoaDAO();

        
        validacao.validarDadosPessoa(listaDadosPessoa);
        if (validacao.mensagem.equals(""))
        {
            pessoa.setId(validacao.id);
            pessoa.setNome(listaDadosPessoa.get(1));
            pessoa.setRg(listaDadosPessoa.get(2));
            pessoa.setCpf(listaDadosPessoa.get(3));
            pessoaDAO.EditarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }

    }

    public void PesquisarPessoaPorNome(List<String> DadosPessoa)
    {
        this.mensagem = "";
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(DadosPessoa.get(1));
        DAL.PessoaDAO pessoaDAO = new DAL.PessoaDAO();
        Estaticos.listaPessoasEstatico = pessoaDAO.PesquisarPessoaPorNome(pessoa);
        this.mensagem = pessoaDAO.mensagem;
    }


}
