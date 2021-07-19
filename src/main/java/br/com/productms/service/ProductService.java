package br.com.productms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.productms.entities.Product;
import br.com.productms.entities.dto.ProductDTO;
import br.com.productms.repositories.ProductRepository;
import br.com.productms.service.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//converter para DTO
    public Product fromDTO(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        return product;
    }
    
    public List<Product> findAll() {

        return productRepository.findAll();
    }
    
    public Product findById (String id){
        Optional<Product> product =  productRepository.findById(id);

        return product.orElseThrow(() -> new ObjectNotFoundException(
                "Produto com o ID " + id  + " não encontrado!"));
    }

    
    @Transactional
    public Product save (Product product){
        return productRepository.save(product);
    }
    
    @Transactional
    public Product update (Product product){
        Product newProduct = findById(product.getId());
        
        updateData(newProduct, product);

        return productRepository.save(newProduct);
    }
    
    private void updateData(Product newProduct, Product product){
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());

    }
    
    @Transactional(readOnly = true)
    public List<Product> findByFilter (Product productFilter){
        Example example = Example.of(productFilter, ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));


        return productRepository.findAll(example);

    }
    
    @Transactional
    public Product delete (String id){
        Product product =  findById(id);
        productRepository.deleteById(product.getId());

        return product;

    }
    
    
	
}
