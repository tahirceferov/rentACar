package org.jafarov.demo.sercice.abstracts;


import org.jafarov.demo.model.request.CreateBrandRequest;
import org.jafarov.demo.model.request.UpdateBrandRequest;
import org.jafarov.demo.model.response.GetAllBrandResponse;
import org.jafarov.demo.model.response.GetByIdBrandResponse;

import java.util.List;

public interface BrandManager {
    List<GetAllBrandResponse> getAll();
    GetByIdBrandResponse getById(Long id);

    void add(CreateBrandRequest createBrandRequest);
    void update (UpdateBrandRequest updateBrandRequest);
        void delete (Long id);
}
