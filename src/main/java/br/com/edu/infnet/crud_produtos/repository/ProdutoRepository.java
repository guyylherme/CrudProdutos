package br.com.edu.infnet.crud_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.edu.infnet.crud_produtos.model.Produto;
import br.com.edu.infnet.crud_produtos.model.ProdutoDto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{
 	
	@Query("FROM Produto c WHERE c.nome = :nome")
	Produto findByName(@Param("nome")String nome);

	Produto save(ProdutoDto produtoDto);

}
