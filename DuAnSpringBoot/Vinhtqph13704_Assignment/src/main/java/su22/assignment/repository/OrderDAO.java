package su22.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import su22.assignment.entities.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{

}
