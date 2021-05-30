package pl.mis.glycemicloadcalculator.mapper;

import lombok.Data;
import pl.mis.glycemicloadcalculator.entity.Product;

@Data
public class OneProductResponse {

    private Long productId;

    private Double quantity;

    private String englishName;

    private String polishName;

    private Double glycemicIndex;

    private Double carbohydrate;

    private Double glycemicLoad;

    public OneProductResponse(Product product, OneProductRequest request) {
        this.productId = product.getId();
        this.englishName = product.getEnglishName();
        this.polishName = product.getPolishName();
        this.glycemicIndex = Double.valueOf(product.getGlycemicIndex());
        this.carbohydrate = Double.valueOf(product.getCarbohydrate());
        this.quantity = request.getQuantity();
        this.glycemicLoad = this.quantity * this.carbohydrate * this.glycemicIndex / 10000;
    }

}
