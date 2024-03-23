package pl.javastart.carzone.domain.ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long>, JpaSpecificationExecutor<Ad>{
}
