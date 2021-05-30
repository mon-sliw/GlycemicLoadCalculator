package pl.mis.glycemicloadcalculator.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mis.glycemicloadcalculator.entity.Product;
import pl.mis.glycemicloadcalculator.mapper.OneProductRequest;
import pl.mis.glycemicloadcalculator.mapper.OneProductResponse;
import pl.mis.glycemicloadcalculator.service.CalculatorService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    CalculatorService service;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product newProduct) {
        Product addedProduct = service.addProduct(newProduct);
        if (addedProduct == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(addedProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> editProduct(@PathVariable Long productId, @RequestBody Product newProduct) {
        Product updatedProduct = service.editProduct(productId, newProduct);
        if (updatedProduct == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long productId) {
        if (service.removeProduct(productId))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        return service.getProductById(productId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        List<Product> allProducts = service.getAllProducts();
        if (allProducts == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping("/calculate-one")
    public ResponseEntity<?> calculateOneProduct(@RequestBody OneProductRequest request) {
        OneProductResponse response = service.calculateOneProduct(request);
        if (response == null)
            return null;
        return ResponseEntity.ok(response);
    }
}
