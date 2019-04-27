package negocio;

import java.util.List;

import javax.annotation.ManagedBean;

import excecoes.CompraException;
import excecoes.LivroNaoEncontradoException;

@ManagedBean
public class LivrariaBean {
    private Livraria sistema = null;
    private String idLivro = "0";

    public LivrariaBean() {
    }      

    public String getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}

	public void setSistema(Livraria livraria) {
        this.sistema = livraria;
    }

    public Livro getLivro() throws LivroNaoEncontradoException {
        return (Livro) sistema.getLivro(idLivro);
    }

    public List<Livro> getLivros() {
        return sistema.getLivros();
    }

    public void comprarLivros(Carrinho cart) throws CompraException {
        sistema.comprarLivros(cart);
    }
}