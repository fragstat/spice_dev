package hse.project.spice.service;

import hse.project.spice.dto.ModelDto;
import hse.project.spice.model.ModelEntity;

import java.util.List;

public interface ModelService {
    List<ModelDto> getModelList();
}
