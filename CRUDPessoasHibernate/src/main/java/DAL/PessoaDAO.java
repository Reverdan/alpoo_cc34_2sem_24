package DAL;

import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PessoaDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(pessoa);
            transaction.commit();
            session.close();
            this.mensagem = "Pessoa cadastrada !!!!!!";
        }
        catch (HibernateException e)
        {
            this.mensagem = "Erro no cadastro";
        }
    }
    
    public Pessoa pesquisarPessoaId(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            pessoa = session.find(Pessoa.class, pessoa.getId());
            session.close();
            if (pessoa == null)
            {
                this.mensagem = "Pessoa não encontrada";
            }
            
        }
        catch (HibernateException e)
        {
            this.mensagem = "Erro na Pesquisa";
        }
        return pessoa;
    }
    
    public void editarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(pessoa);
            transaction.commit();
            session.close();
            this.mensagem = "Pessoa editada !!!!!!";
        }
        catch (HibernateException e)
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
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.getTransaction();
            session.remove(pessoa);
            transaction.commit();
            session.close();
            this.mensagem = "Pessoa Excluída !!!!!!";
        }
        catch (HibernateException e)
        {
            this.mensagem = "Erro na exclusão";
        }
    }
}
