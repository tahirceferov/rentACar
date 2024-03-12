package org.jafarov.demo.sercice.abstracts;


import org.jafarov.demo.model.request.UpdateModelRequest;
import org.jafarov.demo.model.request.CreateModelRequest;
import org.jafarov.demo.model.response.GetAllModelResponse;
import org.jafarov.demo.model.response.GetByIdModelResponse;

import java.util.List;

public interface ModelManager {
    List<GetAllModelResponse> getAll();
    GetByIdModelResponse getById(Long id);
    void add(CreateModelRequest createModelRequest);
    void update (UpdateModelRequest updateModelRequest);
    void delete (Long id);
}
