/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Modelo.Controle;
import Modelo.Estaticos;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rever
 */
@Named(value = "bgrEditar")
@RequestScoped
public class bgrEditar
{
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    private String mensagem;
    
    public bgrEditar()
    {
        this.id = Estaticos.listaPessoasEstatico.get(0).getId();
        this.nome = Estaticos.listaPessoasEstatico.get(0).getNome();
        this.rg = Estaticos.listaPessoasEstatico.get(0).getRg();
        this.cpf = Estaticos.listaPessoasEstatico.get(0).getCpf();
    }
    
    public String editar()
    {
        Controle controle  = new Controle();
        List<String> listaDadosPessoa = new ArrayList<>();
        listaDadosPessoa.add(this.id.toString());
        listaDadosPessoa.add(this.nome);
        listaDadosPessoa.add(this.rg);
        listaDadosPessoa.add(this.cpf);
        controle.EditarPessoa(listaDadosPessoa);
        this.mensagem = controle.mensagem;
        return "/Paginas/RespostaEditar.xhtml";
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
