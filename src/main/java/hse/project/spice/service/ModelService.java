package hse.project.spice.service;

import hse.project.spice.dto.CreateModelRequest;
import hse.project.spice.dto.EditModelRequest;
import hse.project.spice.dto.ModelDto;

import java.util.List;

public interface ModelService {
    List<ModelDto> getModelList();

    void createModel(CreateModelRequest request);

    void deleteModel(Long id);

    ModelDto getModel(Long id);

    void editModel(Long id, EditModelRequest request);
}
