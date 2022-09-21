package hse.project.spice.service.impl;

import hse.project.spice.dto.CreateModelRequest;
import hse.project.spice.dto.ModelDto;
import hse.project.spice.mapper.ModelMapper;
import hse.project.spice.model.Model;
import hse.project.spice.repository.ModelRepository;
import hse.project.spice.service.MinioService;
import hse.project.spice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final MinioService minioService;

    @Override
    public List<ModelDto> getModelList() {
        return modelRepository.findAll().stream()
                .map(ModelMapper::toDto)
                .toList();
    }

    @Override
    public void createModel(CreateModelRequest request) {
        String techLink = "http://localhost:8081/file/" + minioService.uploadFile(request.getTech());
        String modelLink = "http://localhost:8081/file/" + minioService.uploadFile(request.getLink());
        Model model = Model.builder()
                .name(request.getName())
                .manufacturer(request.getManufacturer())
                .maxI(request.getMaxI())
                .maxP(request.getMaxP())
                .maxU(request.getMaxU())
                .maxProbU(request.getMaxProbU())
                .useConditions(request.getUseConditions())
                .box(request.getBox())
                .link(modelLink)
                .techLink(techLink)
                .build();
        modelRepository.save(model);
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

}
