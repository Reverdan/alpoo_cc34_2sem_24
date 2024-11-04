
package DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Modelo.Pessoa;


public class PessoaDAO
{
    public String mensagem;
    
    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            pessoa.setId(null);
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(pessoa);
            transaction.commit();
            session.close();
            this.mensagem = "Pessoa cadastrada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro " + HibernateUtil.mensagem + e.getMessage();
        }
    }

}
