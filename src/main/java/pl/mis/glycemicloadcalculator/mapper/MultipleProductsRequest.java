package pl.mis.glycemicloadcalculator.mapper;

import lombok.Data;

import java.util.List;

@Data
public class MultipleProductsRequest {

    List<OneProductRequest> products;

}
