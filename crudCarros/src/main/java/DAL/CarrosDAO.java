package DAL;

import Modelo.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarrosDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarCarro(Carro carro)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "insert into carros "
                + "(modelo, fabricante, cor, ano, valor) "
                + "values(?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(instrucaoSql);
            stmt.setString(1, carro.getModelo());
            stmt.setString(2, carro.getFabricante());
            stmt.setString(3, carro.getCor());
            stmt.setInt(4, carro.getAno());
            stmt.setDouble(5, carro.getValor());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Carro cadastrado";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro de cadastro";
        }
    }
}
