package pl.mis.glycemicloadcalculator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mis.glycemicloadcalculator.entity.Product;
import pl.mis.glycemicloadcalculator.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    ProductRepository repository;

    @Override
    public Product addProduct(Product newProduct) {
        return repository.save(newProduct);
    }

    @Override
    public Product editProduct(Long productId, Product newProduct) {
        if (repository.existsById(productId)){
            newProduct.setId(productId);
            return repository.save(newProduct);
        }
        return null;
    }

    @Override
    public boolean removeProduct(Long productId) {
        if (repository.existsById(productId)) {
            repository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return repository.findById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        repository.findAll().forEach(allProducts::add);
        return allProducts;
    }
}
