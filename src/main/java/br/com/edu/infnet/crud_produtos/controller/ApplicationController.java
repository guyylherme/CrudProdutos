package br.com.edu.infnet.crud_produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class ApplicationController {
	
	@GetMapping("/iniciar")
	public void iniciar() {		
		System.out.println("Hello Word!"); 		
	}

}
