package su22.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import su22.assignment.entities.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {}
