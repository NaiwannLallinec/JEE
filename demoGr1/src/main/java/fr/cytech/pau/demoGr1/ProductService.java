package fr.cytech.pau.demoGr1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Byte findCommonType(Long personId) {
        if (personId != null) {
            return productRepository.findMostCommonType(personId);
        }
        return null;
    }

    public String findCommonColor(Long personId) {
        if (personId != null) {
            return productRepository.findMostCommonColor(personId);
        }
        return null;
    }

    public Integer findCommonSize(Long personId) {
        if (personId != null) {
            return productRepository.findMostCommonSize(personId);
        }
        return null;
    }
}
