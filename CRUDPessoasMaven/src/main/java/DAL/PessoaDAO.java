package DAL;

import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "select * from pessoas where id = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setInt(1, pessoa.getId());
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
            {
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setRg(resultSet.getString("rg"));
                pessoa.setCpf(resultSet.getString("cpf"));
            }
            else
            {
                this.mensagem = "Pessoa não encontrada";
            }
            
            conexao.desconectar();
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
        return pessoa;
    }
    
    public void editarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "update pessoas "
                    + "set nome = ?, "
                    + "set rg = ?, "
                    + "set cpf = ? "
                    + "where id = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getRg());
            stmt.setString(3, pessoa.getCpf());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Pessoa editada !!!!!!";
        }
        catch (SQLException e)
        {
            this.mensagem = "Erro no editar";
        }
        catch (Exception ex)
        {
            this.mensagem = "Erro indefinido";
        }
    }
    
    public void excluirPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "delete from pessoas "
                    + "where id = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setInt(1, pessoa.getId());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Pessoa Excluída !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro na exclusão";
        }
    }
}
