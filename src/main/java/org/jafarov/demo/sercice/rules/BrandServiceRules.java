package org.jafarov.demo.sercice.rules;

import lombok.AllArgsConstructor;
import org.jafarov.demo.exception.BusinessException;
import org.jafarov.demo.repository.BrandRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandServiceRules {
    private final BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists");
        }
    }
}
