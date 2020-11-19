package hvitclan.com.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hvitclan.com.restful.entites.HocSinh;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh, Long>{

}
