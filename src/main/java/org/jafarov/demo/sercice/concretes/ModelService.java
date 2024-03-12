package org.jafarov.demo.sercice.concretes;

import lombok.AllArgsConstructor;
import org.jafarov.demo.model.Brand;
import org.jafarov.demo.model.Model;
import org.jafarov.demo.model.mappers.ModelMapperService;
import org.jafarov.demo.model.request.CreateModelRequest;
import org.jafarov.demo.model.request.UpdateModelRequest;
import org.jafarov.demo.model.response.GetAllModelResponse;
import org.jafarov.demo.model.response.GetByIdBrandResponse;
import org.jafarov.demo.model.response.GetByIdModelResponse;
import org.jafarov.demo.repository.ModelRepository;
import org.jafarov.demo.sercice.abstracts.ModelManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelService implements ModelManager {
    private final ModelRepository modelRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        return models.stream()
                .map(model -> this.modelMapperService.forBrandResponse().map(model, GetAllModelResponse.class))
                .toList();

    }

    @Override
    public GetByIdModelResponse getById(Long id) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        return this.modelMapperService.forBrandResponse()
                .map(model, GetByIdModelResponse.class);
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forBrandRequest().map(createModelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forBrandRequest().map(updateModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
this.modelRepository.deleteById(id);
    }
}
