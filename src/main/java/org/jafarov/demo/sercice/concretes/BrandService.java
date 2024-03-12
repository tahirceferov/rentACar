package org.jafarov.demo.sercice.concretes;

import lombok.AllArgsConstructor;
import org.jafarov.demo.model.mappers.ModelMapperService;
import org.jafarov.demo.model.Brand;
import org.jafarov.demo.model.request.CreateBrandRequest;
import org.jafarov.demo.model.request.UpdateBrandRequest;
import org.jafarov.demo.model.response.GetAllBrandResponse;
import org.jafarov.demo.model.response.GetByIdBrandResponse;
import org.jafarov.demo.repository.BrandRepository;
import org.jafarov.demo.sercice.abstracts.BrandManager;
import org.jafarov.demo.sercice.rules.BrandServiceRules;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandService implements BrandManager {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandServiceRules brandServiceRules;


    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> this.modelMapperService.forBrandResponse()
                        .map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());

    }

    @Override
    public GetByIdBrandResponse getById(Long id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        return this.modelMapperService.forBrandResponse()
                .map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandServiceRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forBrandRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forBrandRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        this.brandRepository.deleteById(id);
    }
}
