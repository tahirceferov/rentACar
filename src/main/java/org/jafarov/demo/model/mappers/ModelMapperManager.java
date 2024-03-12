package org.jafarov.demo.model.mappers;

import org.modelmapper.ModelMapper;


public interface ModelMapperManager {

    ModelMapper forBrandResponse();

  ModelMapper forBrandRequest();
}
