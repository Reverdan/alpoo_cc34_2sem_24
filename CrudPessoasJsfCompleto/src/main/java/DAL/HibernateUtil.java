
package DAL;

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
        catch (Exception ex)
        {
            mensagem = ex.getMessage();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}
