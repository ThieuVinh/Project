package su22.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import su22.assignment.entities.OrderDetail;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
	@Query("SELECT o FROM OrderDetail o WHERE o.order.user.id = :id")
	public List<OrderDetail> findById(@Param("id") int id);
}
