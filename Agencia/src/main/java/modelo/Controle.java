package modelo;


public class Controle
{
    public String somar(String n1, String n2)
    {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        return String.valueOf(num1 + num2);
    }
}
