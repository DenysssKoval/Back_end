package de.ait.shop43.product.repository;

import de.ait.shop43.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

}
