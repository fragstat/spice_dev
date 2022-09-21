package hse.project.spice.service.impl;

import hse.project.spice.dto.CreateModelRequest;
import hse.project.spice.dto.EditModelRequest;
import hse.project.spice.dto.ModelDto;
import hse.project.spice.mapper.ModelMapper;
import hse.project.spice.model.Model;
import hse.project.spice.repository.ModelRepository;
import hse.project.spice.service.MinioService;
import hse.project.spice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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
        Model model = Model.builder()
                .name(request.getName())
                .manufacturer(request.getManufacturer())
                .maxI(request.getMaxI())
                .maxP(request.getMaxP())
                .maxU(request.getMaxU())
                .maxProbU(request.getMaxProbU())
                .useConditions(request.getUseConditions())
                .box(request.getBox())
                .build();
        if (!"".equals(request.getTech().getOriginalFilename())) {
            model.setTechLink("http://localhost:8081/file/" + minioService.uploadFile(request.getTech()));
        }
        if (!"".equals(request.getLink().getOriginalFilename())) {
            model.setLink("http://localhost:8081/file/" + minioService.uploadFile(request.getLink()));
        }
        modelRepository.save(model);
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public ModelDto getModel(Long id) {
        return ModelMapper.toDto(modelRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void editModel(Long id, EditModelRequest request) {
        Model model = modelRepository.findById(id).orElseThrow(NoSuchElementException::new);
        model.setName(request.getName());
        model.setManufacturer(request.getManufacturer());
        model.setMaxI(request.getMaxI());
        model.setMaxP(request.getMaxP());
        model.setMaxU(request.getMaxU());
        model.setMaxProbU(request.getMaxProbU());
        model.setBox(request.getBox());
        model.setUseConditions(request.getUseConditions());
        model.setLink(request.getLink());
        model.setTechLink(request.getTechLink());
    }

}
