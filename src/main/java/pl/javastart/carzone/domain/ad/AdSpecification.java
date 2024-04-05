package pl.javastart.carzone.domain.ad;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;

public class AdSpecification {

    public static Specification<Ad> withDynamicQuery(String model, String brand, String bodyType, String gearBox,
                                                     String fuel, Integer priceFrom, Integer priceTo,
                                                     Integer mileageFrom, Integer mileageTo,
                                                     Integer powerFrom, Integer powerTo,
                                                     Integer engineSizeFrom, Integer engineSizeTo,
                                                     String location) {
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
            if (gearBox != null && !gearBox.isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("gear"), gearBox));
            }
            if (fuel != null && !fuel.isEmpty()){
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), fuel));
            }
            if (priceFrom != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), priceFrom));
            }
            if (priceTo != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), priceTo));
            }
            if (mileageFrom != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("mileage"), mileageFrom));
            }
            if (mileageTo != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("mileage"), mileageTo));
            }
            if (powerFrom != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("power"), powerFrom));
            }
            if (powerTo != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("power"), powerTo));
            }
            if (engineSizeFrom != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("engineSize"), engineSizeFrom));
            }
            if (engineSizeTo != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("engineSize"), engineSizeTo));
            }
            if (location != null && !location.trim().isEmpty()) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("location")), location.toLowerCase()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}