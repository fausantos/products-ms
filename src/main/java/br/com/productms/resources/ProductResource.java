package br.com.productms.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.productms.entities.Product;
import br.com.productms.resources.exception.ErrorGenericException;
import br.com.productms.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	

    @GetMapping("/listAll")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/searchID/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save ( @Valid @RequestBody Product product){

        try{
            product = productService.save(product);

            return ResponseEntity.status(HttpStatus.CREATED).body(product);

        }
        catch (ErrorGenericException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@Valid @RequestBody Product product, @PathVariable String id){

        productService.update(product);
        return ResponseEntity.ok(product);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  delete (@PathVariable String id){
        Product product = productService.delete(id);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/search")
    public ResponseEntity<?>  findByFilter (
            @RequestParam(value = "name",  required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "min_price", required = false) Double min_price,
            @RequestParam(value = "max_price", required = false) Double max_price
            ){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(min_price);
        product.setPrice(max_price);

        List<Product> productList = productService.findByFilter(product);



        return ResponseEntity.ok(productList);
    }
	
	
	
	


}
