package com.dio.projeto4.repository;

import com.dio.projeto4.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
