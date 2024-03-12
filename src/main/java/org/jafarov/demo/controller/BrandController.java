package org.jafarov.demo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jafarov.demo.model.request.CreateBrandRequest;
import org.jafarov.demo.model.request.UpdateBrandRequest;
import org.jafarov.demo.model.response.GetAllBrandResponse;
import org.jafarov.demo.model.response.GetByIdBrandResponse;
import org.jafarov.demo.sercice.concretes.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;


    @GetMapping
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }


    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable Long id) {
        return brandService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid @RequestBody CreateBrandRequest brandRequest) {
        brandService.add(brandRequest);

    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        brandService.delete(id);
    }
}
