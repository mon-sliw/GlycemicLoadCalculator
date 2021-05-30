package pl.mis.glycemicloadcalculator.mapper;

import lombok.Data;

@Data
public class OneProductRequest {

    Long productId;

    Double quantity;
}
