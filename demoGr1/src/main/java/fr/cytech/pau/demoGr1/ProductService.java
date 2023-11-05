package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Byte findCommonType(Long personId) {
        return productRepository.findMostCommonType(personId);
    }

    public String findCommonColor(Long personId) {
        return productRepository.findMostCommonColor(personId);
    }

    public Integer findCommonSize(Long personId) {
        return productRepository.findMostCommonSize(personId);
    }
}
