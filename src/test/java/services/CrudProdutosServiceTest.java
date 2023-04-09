package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.edu.infnet.crud_produtos.model.Categoria;
import br.com.edu.infnet.crud_produtos.model.Produto;
import br.com.edu.infnet.crud_produtos.model.ProdutoDto;
import br.com.edu.infnet.crud_produtos.repository.ProdutoRepository;
import br.com.edu.infnet.crud_produtos.service.ProdutoService;

public class CrudProdutosServiceTest {
	
	@Mock
	ProdutoRepository repository;
	ProdutoService service;
	 
	
	@Test
	void save() {
		ProdutoDto novoProduto = new ProdutoDto("Caixa de Bombom", "Chocolate", 10, Categoria.COMIDA);
		Mockito.when(repository.save(novoProduto.converter())).thenReturn(novoProduto.toProduto());
		
		ProdutoDto novoProdutoSalvo = service.save(novoProduto);		
		assertEquals(novoProduto.getNome(), novoProdutoSalvo.getNome());
		assertEquals(novoProduto.getDescricao(), novoProdutoSalvo.getDescricao());
		assertEquals(novoProduto.getPreco(), novoProdutoSalvo.getPreco());
		assertEquals(novoProduto.getCategoria(), novoProdutoSalvo.getCategoria());
	}
	
	@Test
	void find() {
		ProdutoDto produtoBuscado = new ProdutoDto("Coca-Cola", "Refrigerante", 5, Categoria.BEBIBA);
		Mockito.when(repository.findByName("Coca-Cola")).thenReturn(Optional.ofNullable(produtoBuscado.toProduto()));
		
		ProdutoDto produtoRetornado = service.findByName("Coca-Cola");
		assertEquals(produtoBuscado.getNome(), produtoRetornado.getNome());
		assertEquals(produtoBuscado.getDescricao(), produtoRetornado.getDescricao());
		assertEquals(produtoBuscado.getPreco(), produtoRetornado.getPreco());
		assertEquals(produtoBuscado.getCategoria(), produtoRetornado.getCategoria());			
	}
	
	@Test
	void findAll() {
		Mockito.when(repository.findAll()).thenReturn(produtos());
		
		List<ProdutoDto> listaProdutos = service.findAll();
		assertEquals(2, listaProdutos.size());		
	}
	
	@Test
	void delete() {
		service.deleteById("Caixa de Bombom");
		Mockito.verify(repository).deleteById("Caixa de Bombom");
	}
	
	private List<Produto> produtos(){
		Produto produto1 = new Produto("Traquinas", "Biscoito", 3, Categoria.COMIDA);
		Produto produto2 = new Produto("Mate", "Suco", 4, Categoria.BEBIBA);

	}

}








