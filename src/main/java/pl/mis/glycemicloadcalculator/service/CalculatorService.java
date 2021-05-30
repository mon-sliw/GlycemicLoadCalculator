package pl.mis.glycemicloadcalculator.service;

import pl.mis.glycemicloadcalculator.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CalculatorService {

    Product addProduct(Product newProduct);

    Product editProduct(Long productId, Product newProduct);

    boolean removeProduct(Long productId);

    Optional<Product> getProductById(Long productId);

    List<Product> getAllProducts();
}
