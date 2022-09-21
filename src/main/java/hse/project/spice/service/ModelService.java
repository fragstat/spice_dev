package hse.project.spice.service;

import hse.project.spice.dto.CreateModelRequest;
import hse.project.spice.dto.ModelDto;

import java.util.List;

public interface ModelService {
    List<ModelDto> getModelList();

    void createModel(CreateModelRequest request);

    void deleteModel(Long id);
}
