package pl.mis.glycemicloadcalculator.mapper;

import lombok.Data;

@Data
public class OneProductRequest {

    private Long productId;

    private Double quantity;
}
