
package ManagedBeans;

import Modelo.Estaticos;
import Modelo.Pessoa;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;


@Named(value = "bgrPEE")
@RequestScoped
public class bgrPEE
{

    private String id;
    private String nome;
    private String rg;
    private String cpf;
    private String mensagem;
    private List<Pessoa> listaPessoas;
    
    public bgrPEE()
    {
    }
    
    public String selecionar(String nome)
    {
        this.nome = nome;
        System.out.println("selecionar");
        return pesquisarPorNome();
    }
    
    public String excluirPorNome()
    {
        return "/Paginas/RespostaExclusao.xhtml";
    }
    
    public String paginaEdicao()
    {
        return "/Paginas/Editar.xhtml";
    }
    
    
    
    public String pesquisarPorNome()
    {
        System.out.println("Pesquisar");
        Modelo.Controle controle = new Modelo.Controle();
        List<String> dadosPessoa = new ArrayList<>();
        listaPessoas = new ArrayList<>();
        dadosPessoa.add("0");
        dadosPessoa.add(this.nome);
        dadosPessoa.add("");
        dadosPessoa.add("");
        controle.PesquisarPessoaPorNome(dadosPessoa);
        
        this.mensagem = controle.mensagem;
        if (Estaticos.listaPessoasEstatico == null || Estaticos.listaPessoasEstatico.isEmpty())
        {
            this.mensagem = "Não existe resposta para esta pesquisa";
            return null;
        }
        else
            if (Estaticos.listaPessoasEstatico.size() == 1)
            {
                this.id = Estaticos.listaPessoasEstatico.get(0).getId().toString();
                this.nome = Estaticos.listaPessoasEstatico.get(0).getNome();
                this.rg = Estaticos.listaPessoasEstatico.get(0).getRg();
                this.cpf = Estaticos.listaPessoasEstatico.get(0).getCpf();
                
                return null;
            }
            else
            {
                listaPessoas = Estaticos.listaPessoasEstatico;
                return "/Paginas/RespostaPesquisaNome.xhtml";
            }
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public List<Pessoa> getListaPessoas()
    {
        return listaPessoas;
    }

    public void setListaPessoas(List<Pessoa> listaPessoas)
    {
        this.listaPessoas = listaPessoas;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    
    
}
