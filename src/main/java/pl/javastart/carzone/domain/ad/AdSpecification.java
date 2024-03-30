package pl.javastart.carzone.domain.ad;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

public class AdSpecification {

    public static Specification<Ad> withDynamicQuery(String model, String brand,String bodyType) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (model != null && !model.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("vehicleModel"), model));
            }

            if (brand != null && !brand.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("vehicleBrand"), brand));
            }

            if (bodyType != null && !bodyType.isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("bodyType"), bodyType));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}