package com.devsuperior.dscommerce.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {

	/*
	 * @Autowired 
	 * Quando uma classe possui apenas um construtor, o Spring consegue
	 * identificar automaticamente que ele deve ser utilizado para injeção de
	 * dependências. 
	 * Não precisamos de @Autowired porque, desde o Spring 4.3, quando
	 * existe apenas um construtor, ele é utilizado automaticamente para injeção de
	 * dependências.
	 */
	private final ProductRepository repository;

	ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {

		/*
		 * Imagine que você tenha um método que busca um produto no banco de dados: Se o
		 * produto não existir, o método retorna null. Em vez de retornar um objeto que
		 * pode ser null, você retorna um Optional. Optional com um produto. Optional
		 * vazio, quando o produto não existe.
		 */
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product);
		return dto;
	}

}
