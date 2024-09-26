package Modelo;

import DAL.PessoaDAO;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void cadastrarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosPessoa(listaDadosPessoa);
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(listaDadosPessoa.get(0));
            pessoa.setRg(listaDadosPessoa.get(1));
            pessoa.setCpf(listaDadosPessoa.get(2));
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
    }
    
    public Pessoa pesquisarPessoaId(List<String> listaDadosPessoa)
    {
        return null;
    }
    
    public void editarPessoa(List<String> listaDadosPessoa)
    {
        
    }
    
    public void excluirPessoa(List<String> listaDadosPessoa)
    {
        
    }
}
