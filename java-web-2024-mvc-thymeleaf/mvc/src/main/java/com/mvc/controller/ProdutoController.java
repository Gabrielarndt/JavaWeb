package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.modelos.Product;

@Controller
public class ProdutoController {
	private List<Product> lista = new ArrayList<>();
	
    @GetMapping("/")
	public String hello(Model model) {        
	   /* lista.add(new Product(1l,"Milho", 15.50));
	    lista.add(new Product(2l,"Feijão", 25.50));
	    lista.add(new Product(3l,"Arroz", 5.50));*/
	    
	    model.addAttribute("products", lista);
		return "index";
	}
	
	@GetMapping("/produto/add")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "/produto/add";
	}
	
	@PostMapping("/produto/add")
	public String add(@ModelAttribute Product product) {
		product.setId(lista.size()+1l);
		lista.add(product);
		return "redirect:/";
	}
	
	@GetMapping("/produto/{productId}/edit")
	public String showFormEdit(@PathVariable("productId") Long productId, Model model) {
		Product productEdit = null;
		for(Product prod : lista) {
			if(prod.getId() == productId) {
				productEdit = prod;
				break;
			}
		}
		model.addAttribute("product", productEdit);
		return "/produto/edit";
	}
	
	@PostMapping("/produto/{productId}/edit")
	public String showFormEdit(@PathVariable("productId") Long productId, @ModelAttribute Product product) {
		for(Product prod : lista) {
			if(prod.getId() == productId) {
			  prod.setDescricao(product.getDescricao());
			  prod.setPreco(product.getPreco());
			  break;
			}
		}
		return "redirect:/";
	}
	
}
