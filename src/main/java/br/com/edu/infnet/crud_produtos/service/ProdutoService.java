package br.com.edu.infnet.crud_produtos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.edu.infnet.crud_produtos.controller.ProdutoController;
import br.com.edu.infnet.crud_produtos.model.Produto;
import br.com.edu.infnet.crud_produtos.model.ProdutoDto;
import br.com.edu.infnet.crud_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
    private static final Logger log = LoggerFactory.getLogger(ProdutoController.class); 
	
	@Autowired
	public ProdutoRepository produtoRepository;
	 

	public List<ProdutoDto> findAll() {
		log.info("Buscando todos os produtos");
		List<Produto> produtos = produtoRepository.findAll();
		return produtos.stream().map(Produto::toDto).toList();
	}
	
	public ProdutoDto findByName(String nome) {		
		log.info("Buscando produto por nome : {}", nome);
		Produto produto = produtoRepository.findByName(nome);		
		if (!StringUtils.isEmpty(produto)) {			
			return produto.toDto();
		}		
		return null;
	}

	public ProdutoDto save(ProdutoDto produtoDto) {
		log.info("Salvando produto : {}", produtoDto);
		Produto produto = produtoRepository.save(produtoDto.converter());
		return produto.toDto();
	}

	public void deleteById(String nome) {
		produtoRepository.deleteById(nome);
	}
	

}
