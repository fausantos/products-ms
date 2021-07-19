package br.com.productms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.productms.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
