package com.maisPraTi.atividade16.repository;

import com.maisPraTi.atividade16.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
