package hvitclan.com.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hvitclan.com.restful.entites.Lop;

@Repository
public interface LopRepository extends JpaRepository<Lop, Long>{

}
