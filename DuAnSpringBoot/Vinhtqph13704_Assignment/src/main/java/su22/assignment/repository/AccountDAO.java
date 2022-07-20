package su22.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import su22.assignment.entities.Account;

public interface AccountDAO extends JpaRepository<Account, Integer>{
	@Query("SELECT a FROM Account a WHERE a.username LIKE :username")
	public Account findAccountByUsername(String username);
}
