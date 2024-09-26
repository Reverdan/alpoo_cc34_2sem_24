package DAL;

import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PessoaDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getRg());
            stmt.setString(3, pessoa.getCpf());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Pessoa cadastrada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
    }
    
    public Pessoa pesquisarPessoaId(Pessoa pessoa)
    {
        return pessoa;
    }
    
    public void editarPessoa(Pessoa pessoa)
    {
        
    }
    
    public void excluirPessoa(Pessoa pessoa)
    {
        
    }
}
