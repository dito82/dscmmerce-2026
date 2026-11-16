package com.devsuperior.dscommerce.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.ProductDTO;
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
	
	@GetMapping
	public Page<ProductDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);

	}
}
