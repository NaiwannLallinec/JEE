package fr.cytech.pau.demoGr1;

import jakarta.persistence.*;

@Entity
public class ProductRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "productRating")
    private Product product;

}
