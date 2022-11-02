package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	ProductRepository productRepository;
	
	@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String name) {
        return productRepository.findByProductTypeName(name);
    }
    
    public List<ProductType> findAllProductTypes(){
    	return productRepository.findAllProductTypes();
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
