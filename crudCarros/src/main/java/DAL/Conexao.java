package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

/*
create database crudCarros
go
use crudCarros
go
create table Carros
(
	id int primary key identity(1,1),
	modelo varchar(20),
	fabricante varchar(20),
	cor varchar(10),
	ano int,
	valor float
)
*/

public class Conexao
{
    public Connection con;
    public String mensagem;
    private String stringConexao = "jdbc:sqlserver://localhost\\DESKTOP-CJH0B9P:1433;"
            + "databaseName=crudCarros;"
            + "encrypt=false";
    
    public Connection conectar()
    {
        this.mensagem = "";
        try
        {
            if (con == null || con.isClosed())
            {
                con = DriverManager.getConnection(stringConexao, "sa", "rever");
            }
        }
        catch (Exception e)
        {
            mensagem = "Erro de conexão";
        }
        return con;
    }
    
    public void desconectar()
    {
        try
        {
            if (!con.isClosed())
                con.close();
        }
        catch (Exception e)
        {
            mensagem = "Erro ao fechar conexão";
        }
    }
}
