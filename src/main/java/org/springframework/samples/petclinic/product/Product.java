package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="productos")
public class Product{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
    Integer id;
	
	
	@Column(name="name")
	@Length(max = 50,min = 3)
	@NotEmpty
    String name;
	
	
	@PositiveOrZero
	@Column(name="price")
    double price;

	
	
	@ManyToOne
	@JoinColumn(name="tipo_de_producto")
    ProductType productType;
	
   
}
