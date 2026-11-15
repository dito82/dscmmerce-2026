package com.devsuperior.dscommerce.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	/*
	 * @Autowired 
	 * Quando uma classe possui apenas um construtor, o Spring consegue
	 * identificar automaticamente que ele deve ser utilizado para injeção de
	 * dependências. 
	 * Não precisamos de @Autowired porque, desde o Spring 4.3, quando
	 * existe apenas um construtor, ele é utilizado automaticamente para injeção de
	 * dependências.
	 */
	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		return service.findById(id);

	}
}
