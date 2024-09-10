package Modelo;

import DAL.CarrosDAO;
import java.util.List;

public class Controle
{
    public String mensagem;
    
    public void cadastrarCarro(List<String> listaDadosCarro)
    {
        Validacao validacao = new Validacao();
        validacao.validarCarro(listaDadosCarro);
        if (validacao.mensagem.equals(""))
        {
            Carro carro = new Carro();
            carro.setModelo(listaDadosCarro.get(0));
            carro.setFabricante(listaDadosCarro.get(1));
            carro.setCor(listaDadosCarro.get(2));
            carro.setAno(validacao.ano);
            carro.setValor(validacao.valor);
            CarrosDAO carrosDAO = new CarrosDAO();
            carrosDAO.cadastrarCarro(carro);
            this.mensagem = carrosDAO.mensagem;
        }
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }
}
