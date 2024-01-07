package pl.javastart.carzone.domain.ad;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {
    List<Ad> findAll();
}
