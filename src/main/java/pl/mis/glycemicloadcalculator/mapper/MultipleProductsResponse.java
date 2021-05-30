package pl.mis.glycemicloadcalculator.mapper;

import lombok.Data;
import pl.mis.glycemicloadcalculator.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Data
public class MultipleProductsResponse {

    private Double totalGlycemicLoad = 0.0;

    private List<OneProductResponse> products = new ArrayList<>();

    public void add(Product product, OneProductRequest request){
        OneProductResponse response = new OneProductResponse(product, request);
        products.add(response);
        totalGlycemicLoad += response.getGlycemicLoad();
    }
}
