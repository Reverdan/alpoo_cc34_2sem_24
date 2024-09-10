package Modelo;

import java.util.List;

public class Validacao
{
   public String mensagem = "";
   public int ano;
   public Double valor;
   
   public void validarCarro(List<String> listaDadosCarro)
   {
       this.mensagem = "";
       
       if (listaDadosCarro.get(0).length() == 0)
           this.mensagem += "Modelo obrigatorio";
       if (listaDadosCarro.get(1).length() == 0)
           this.mensagem += "Fabricante obrigatorio";
       if (listaDadosCarro.get(2).length() == 0)
           this.mensagem += "Cor obrigatorio";
       try
       {
           this.ano = Integer.parseInt(listaDadosCarro.get(3));
           this.valor = Double.parseDouble(listaDadosCarro.get(4));
       }
       catch (Exception e)
       {
           this.mensagem = "Erro de ano ou valor";
       }
   }
}
