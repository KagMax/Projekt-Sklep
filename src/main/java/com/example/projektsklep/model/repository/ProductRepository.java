package com.example.projektsklep.model.repository;



import com.example.projektsklep.model.entities.product.Product;
import com.example.projektsklep.model.entities.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);


    Optional<Product> findById(long id);

    Product save(Product product);;

    void delete(Product product);

    void deleteById(long id); // Dodana metoda
}
