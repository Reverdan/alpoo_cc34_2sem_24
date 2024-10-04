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
            pessoa.setNome(listaDadosPessoa.get(1));
            pessoa.setRg(listaDadosPessoa.get(2));
            pessoa.setCpf(listaDadosPessoa.get(3));
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
    }
    
    public Pessoa pesquisarPessoaId(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarIdPessoa(listaDadosPessoa.get(0));
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            pessoa.setId(validacao.id);
            pessoa = pessoaDAO.pesquisarPessoaId(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
        return pessoa;
    }
    
    public void editarPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosPessoa(listaDadosPessoa);
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(validacao.id);
            pessoa.setNome(listaDadosPessoa.get(1));
            pessoa.setRg(listaDadosPessoa.get(2));
            pessoa.setCpf(listaDadosPessoa.get(3));
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.editarPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
    }
    
    public void excluirPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        Validacao validacao = new Validacao();
        validacao.validarIdPessoa(listaDadosPessoa.get(0));
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            pessoa.setId(validacao.id);
            pessoaDAO.excluirPessoa(pessoa);
            this.mensagem = pessoaDAO.mensagem;
        }
    }
}
