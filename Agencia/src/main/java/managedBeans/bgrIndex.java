package managedBeans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import modelo.Controle;

@Named(value = "bgrIndex")
@RequestScoped
public class bgrIndex
{
    private String n1;
    private String n2;
    private String resultado;
    
    public bgrIndex()
    {
    }
    
    public void somar()
    {
        Controle controle = new Controle();
        this.resultado = controle.somar(n1, n2);
    }
    
    

    public String getN1()
    {
        return n1;
    }

    public void setN1(String n1)
    {
        this.n1 = n1;
    }

    public String getN2()
    {
        return n2;
    }

    public void setN2(String n2)
    {
        this.n2 = n2;
    }

    public String getResultado()
    {
        return resultado;
    }

    public void setResultado(String resultado)
    {
        this.resultado = resultado;
    }
    
    
}
