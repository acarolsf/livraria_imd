package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import excecoes.CompraException;
import excecoes.LivroNaoEncontradoException;

public class Livraria {

	private List<Livro> estoqueLivros;

    public Livraria() {
    	estoqueLivros = new ArrayList<Livro>();
        popularLivros();
    }

    private void popularLivros() {
    	 Livro Livro = new Livro();
         Livro.setIdLivro("12341");
         Livro.setAno(2009);
         Livro.setTitulo("Use A Cabeça! Programação");
         Livro.setAutor(" Paul Barry");
         Livro.setQuantidade(10);
         Livro.setPreco(65.5);        
         estoqueLivros.add(Livro);
         
         Livro = new Livro();
         Livro.setIdLivro("12432");
         Livro.setAno(2012);
         Livro.setTitulo("Use a cabeça! Java");
         Livro.setAutor(" Kathy Sierra e Bert Bates");
         Livro.setQuantidade(10);
         Livro.setPreco(110.9);
         estoqueLivros.add(Livro);
         
         Livro = new Livro();
         Livro.setIdLivro("12433");
         Livro.setAno(2012);
         Livro.setTitulo("Use a Cabeça! SQL");
         Livro.setAutor("Lynn Beighley");
         Livro.setQuantidade(10);
         Livro.setPreco(85.9);
         estoqueLivros.add(Livro);
         
         
         Livro = new Livro();
         Livro.setIdLivro("12434");
         Livro.setAno(2012);
         Livro.setTitulo("Use a Cabeça! HTML e CSS");
         Livro.setAutor(" Eric Freeman e Elisabeth Freeman");
         Livro.setQuantidade(10);
         Livro.setPreco(95.9);
         estoqueLivros.add(Livro);
    }
    
    public List<Livro> getLivros() {
        return Collections.unmodifiableList(estoqueLivros);
    }

    public Livro getLivro(String idLivro) throws LivroNaoEncontradoException {
        Livro LivroProcurado = null;
        for (Livro book : estoqueLivros) {
            if (book.getIdLivro().equals(idLivro)) {
            	LivroProcurado = book;
            }
        }

        if (LivroProcurado == null) {
            throw new LivroNaoEncontradoException(
            "Não foi possível encontrar o Livro: " + idLivro);
        }

        return LivroProcurado;
    }
    
    public void comprarLivros(Carrinho carrinho) throws CompraException {
        Collection<ItemCompra> items = carrinho.getItens();
        Iterator<ItemCompra> i = items.iterator();

        while (i.hasNext()) {
            ItemCompra item = (ItemCompra) i.next();
            Livro Livro = (Livro) item.getItem();
            String id = Livro.getIdLivro();
            int quantity = item.getQuantidade();
            comprarLivro(id, quantity);
        }
    }

    public void comprarLivro(String idLivro, int qtdComprada)
            throws CompraException {
        Livro LivroSelecionado;
        try {
        	LivroSelecionado = getLivro(idLivro);
        } catch (LivroNaoEncontradoException e) {
            throw new CompraException(e.getMessage());
        }

        int qtdEstoque = LivroSelecionado.getQuantidade();

        if ((qtdEstoque - qtdComprada) >= 0) {
            int novaQtd = qtdEstoque - qtdComprada;
            LivroSelecionado.setQuantidade(novaQtd);
        } else {
            throw new CompraException("Livro " + idLivro  + " sem estoque suficiente.");
        }
    }

    public void fechar() {
        // liberaria conexões de banco de dados, se usasse
    }
	
}
