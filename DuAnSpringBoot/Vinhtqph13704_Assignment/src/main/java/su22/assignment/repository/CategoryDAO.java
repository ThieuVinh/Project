package su22.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import su22.assignment.entities.Category;


public interface CategoryDAO extends JpaRepository<Category, Integer>{

}
