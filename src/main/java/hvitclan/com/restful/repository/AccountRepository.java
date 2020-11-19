package hvitclan.com.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hvitclan.com.restful.entites.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
}
