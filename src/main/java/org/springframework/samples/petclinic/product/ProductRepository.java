package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product,Integer>{
	
    Product findByName(String name);
    Optional<Product> findById(int id);
    

    
    @Query("SELECT product FROM Product product WHERE product.price <=:price")
	public List<Product> findByPriceLessThan(@Param("price") double price);
    
    @Query("SELECT productType FROM ProductType productType")
	public List<ProductType> findAllProductTypes();
    
    @Query("SELECT product FROM Product product")
	public  List<Product> findAll();
    
    @Query("SELECT productType FROM ProductType productType WHERE productType.name=:name")
	public ProductType findByProductTypeName(@Param("name") String name);
}
