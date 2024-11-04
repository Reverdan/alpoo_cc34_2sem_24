
package DAL;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil
{
    public static String mensagem = "";
    
    private static SessionFactory sessionFactory = null;
    
    static 
    {
        try
        {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (HibernateException ex)
        {
            mensagem = ex.getMessage();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}
