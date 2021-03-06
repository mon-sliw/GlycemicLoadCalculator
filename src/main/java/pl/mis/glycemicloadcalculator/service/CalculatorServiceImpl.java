package pl.mis.glycemicloadcalculator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mis.glycemicloadcalculator.entity.Product;
import pl.mis.glycemicloadcalculator.mapper.MultipleProductsRequest;
import pl.mis.glycemicloadcalculator.mapper.MultipleProductsResponse;
import pl.mis.glycemicloadcalculator.mapper.OneProductRequest;
import pl.mis.glycemicloadcalculator.mapper.OneProductResponse;
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
        if (repository.existsById(productId)) {
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

    @Override
    public OneProductResponse calculateOneProduct(OneProductRequest request) {

        if (repository.findById(request.getProductId()).isPresent()) {
            Product product = repository.findById(request.getProductId()).get();
            return new OneProductResponse(product, request);
        }
        return null;
    }

    @Override
    public MultipleProductsResponse calculateMultipleProducts(MultipleProductsRequest multipleProductsRequest) {
        MultipleProductsResponse response = new MultipleProductsResponse();
        multipleProductsRequest.getProducts().forEach(
                request -> {
                    repository.findById(request.getProductId())
                            .map(product -> {
                                response.add(product, request);
                                return product;
                            });
                });
        return response;
    }
}
