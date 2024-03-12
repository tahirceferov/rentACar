package org.jafarov.demo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jafarov.demo.model.request.CreateModelRequest;
import org.jafarov.demo.model.request.UpdateBrandRequest;
import org.jafarov.demo.model.request.UpdateModelRequest;
import org.jafarov.demo.model.response.GetAllModelResponse;
import org.jafarov.demo.model.response.GetByIdModelResponse;
import org.jafarov.demo.sercice.concretes.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
@AllArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdModelResponse getById(@PathVariable Long id) {
        return modelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);

    }

    @PutMapping()
    public void update(@RequestBody UpdateModelRequest updateModelRequest) {
        modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        modelService.delete(id);
    }

 

}
