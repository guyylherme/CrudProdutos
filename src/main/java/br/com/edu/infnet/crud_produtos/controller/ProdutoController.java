package br.com.edu.infnet.crud_produtos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.infnet.crud_produtos.model.ProdutoDto;
import br.com.edu.infnet.crud_produtos.service.ProdutoService;
 

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
    private static final Logger log = LoggerFactory.getLogger(ProdutoController.class); 

    @Autowired
   	public ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDto> findAll() {
    	log.info("findAll request");
    	return produtoService.findAll();
    }
    
    @GetMapping("/{nome}")
	public ProdutoDto findByName(@PathVariable("nome") String nome) {
		log.info("findByName request");
		return produtoService.findByName(nome);
	}
    
    @PostMapping(produces = "application/json")
    public ProdutoDto save(@RequestBody ProdutoDto produto) {
    	System.out.println(produto);
    	log.info("save new product request");
    	return produtoService.save(produto);
    }
    
    @DeleteMapping("/{nome}")
    public void deleteById(@PathVariable("nome") String nome) {
    	log.info("deleteById request");
    	produtoService.deleteById(nome);
    }
	
}





