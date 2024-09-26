package Modelo;

import java.util.List;

public class Validacao
{
    public String mensagem;
    
    public void validarDadosPessoa(List<String> listaDadosPessoa)
    {
        this.mensagem = "";
        if (listaDadosPessoa.get(0).length() < 3)
            this.mensagem += "Nome deve ter Mais que 3 caracteres \n";
        if (listaDadosPessoa.get(0).length() > 50)
            this.mensagem += "Nome deve ter menos que 50 caracteres \n";
        if (listaDadosPessoa.get(1).length() > 10)
            this.mensagem += "RG deve ter menos que 10 caracteres \n";
        if (listaDadosPessoa.get(2).length() > 12)
            this.mensagem += "CPF deve ter menos que 12 caracteres \n";
    }
}
