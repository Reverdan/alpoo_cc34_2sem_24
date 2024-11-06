
package DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Modelo.Pessoa;
import java.util.List;
import org.hibernate.query.Query;


public class PessoaDAO
{
    public String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        pessoa.setId(null);
        try
        {
            
            Transaction transaction = session.beginTransaction();
            session.persist(pessoa);
            transaction.commit();
            this.mensagem = "Pessoa cadastrada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro " + HibernateUtil.mensagem + e.getMessage();
        }
    }
    
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa)
    {
        this.mensagem = "";
        Query q = session.createQuery("from Pessoa p where p.id = :id");
        q.setParameter("id", pessoa.getId());
        if (q.list().size() < 1) this.mensagem = "Não existe este ID";
        else pessoa = (Pessoa) q.list().get(0);
        return pessoa;
    }
    
     public void ExcluirPessoa(Pessoa pessoa)
    {
        mensagem = "";
        session.beginTransaction();
        session.delete(pessoa);
        session.getTransaction().commit();
        session.close();
        mensagem = "Cadastro excluido";
    }

    public void EditarPessoa(Pessoa pessoa)
    {
        mensagem = "";
        session.beginTransaction();
        session.merge(pessoa);
        session.getTransaction().commit();
        session.close();
        mensagem = "Pessoa editado";
    }
    
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa)
    {
        this.mensagem = "";
        Query query = session.createQuery("from Pessoa p where p.nome like :nome");
        query.setParameter("nome", pessoa.getNome() + "%");
        return (List<Pessoa>) query.list();
    }



}
