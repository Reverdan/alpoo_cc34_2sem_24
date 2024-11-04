/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rever
 */
@Named(value = "bgrCadastro")
@RequestScoped
public class bgrCadastro
{
    private String nome;
    private String rg;
    private String cpf;
    private String mensagem;
    
    public bgrCadastro()
    {
    }
    

    
    public String cadastrar()
    {
        this.mensagem = "";
        Modelo.Controle controle = new Modelo.Controle();
        List<String> dadosPessoa = new ArrayList<>();
        List<List<String>> dadosEnderecos = new ArrayList<>();
        dadosPessoa.add("0");
        dadosPessoa.add(this.nome);
        dadosPessoa.add(this.rg);
        dadosPessoa.add(cpf);
        controle.CadastrarPessoa(dadosPessoa, dadosEnderecos);
        this.mensagem = controle.mensagem;
        return "/Paginas/RespostaCadastro.xhtml";
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getRg()
    {
        return rg;
    }

    public void setRg(String rg)
    {
        this.rg = rg;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

}
