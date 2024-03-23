package pl.javastart.carzone.domain.ad;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.javastart.carzone.domain.user.User;

import java.awt.print.Pageable;
import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long>, JpaSpecificationExecutor<Ad>{
    List<Ad> findByUserEmail(String email);

}
