package hse.project.spice.service.impl;

import hse.project.spice.dto.ModelDto;
import hse.project.spice.mapper.ModelMapper;
import hse.project.spice.model.ModelEntity;
import hse.project.spice.repository.ModelRepository;
import hse.project.spice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Override
    public List<ModelDto> getModelList() {
        return modelRepository.findAll().stream()
                .map(ModelMapper::toDto)
                .toList();
    }

}
