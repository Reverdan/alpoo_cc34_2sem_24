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

}
