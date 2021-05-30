package pl.mis.glycemicloadcalculator.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mis.glycemicloadcalculator.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
