package pl.mis.glycemicloadcalculator.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "polish_name")
    private String polishName;

    @Column(name = "glycemic_index")
    private String glycemicIndex;

    @Column(name = "carbohydrate")
    private String carbohydrate;
}
