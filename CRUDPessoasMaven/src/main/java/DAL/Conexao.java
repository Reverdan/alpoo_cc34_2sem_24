package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//jdbc:sqlserver://localhost\DESKTOP-CJH0B9P:1433;databaseName=crudJavaPessoas;encrypt=false

public class Conexao 
{
    Connection conexao;
    public String mensagem;
    
    public Connection conectar()
    {
        this.mensagem = "";
        try
        {
            if (conexao == null || conexao.isClosed())
            {
                conexao = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\DESKTOP-CJH0B9P:1433;"
                            + "databaseName=crudJavaPessoas;"
                            + "encrypt=false", "sa", "rever");
            }
        }
        catch (SQLException e)
        {
            this.mensagem = "Erro conexão com BD";
        }
        return conexao;
    }
    
    public void desconectar()
    {
        try
        {
            if (!conexao.isClosed())
            {
                conexao.close();
            }
        }
        catch (SQLException e)
        {
            this.mensagem = "Erro ao fechar o BD";
        }
    }
}
