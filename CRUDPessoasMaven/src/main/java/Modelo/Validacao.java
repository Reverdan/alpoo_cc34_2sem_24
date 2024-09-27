package Modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    public int id;
    
    public void validarIdPessoa(String identificacao)
    {
        this.mensagem = "";
        try
        {
            this.id = Integer.parseInt(identificacao);
        }
        catch (Exception e)
        {
            this.mensagem = "ID inválido";
        }
    }
    
    public void validarDadosPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        validarIdPessoa(listaDadosPessoa.get(0));
        if (listaDadosPessoa.get(1).length() < 3)
            this.mensagem += "Nome deve ter Mais que 3 caracteres \n";
        if (listaDadosPessoa.get(1).length() > 50)
            this.mensagem += "Nome deve ter menos que 50 caracteres \n";
        if (listaDadosPessoa.get(2).length() > 10)
            this.mensagem += "RG deve ter menos que 10 caracteres \n";
        if (listaDadosPessoa.get(3).length() > 12)
            this.mensagem += "CPF deve ter menos que 12 caracteres \n";
    }
}
