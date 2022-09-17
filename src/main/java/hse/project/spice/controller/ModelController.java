package hse.project.spice.controller;

import hse.project.spice.dto.ModelDto;
import hse.project.spice.model.ModelEntity;
import hse.project.spice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping
    public List<ModelDto> getModels() {
        return modelService.getModelList();
    }

}
