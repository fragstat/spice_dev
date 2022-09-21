package hse.project.spice.controller;

import hse.project.spice.dto.CreateModelRequest;
import hse.project.spice.dto.EditModelRequest;
import hse.project.spice.dto.ModelDto;
import hse.project.spice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ModelDto getModel(@PathVariable Long id) {
        return modelService.getModel(id);
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> createModel(CreateModelRequest request) {
        if ((!"".equals(request.getLink().getOriginalFilename()) &&
                !MediaType.APPLICATION_PDF_VALUE.equals(request.getLink().getContentType())) ||
                (!"".equals(request.getTech().getOriginalFilename()) &&
                        !MediaType.APPLICATION_PDF_VALUE.equals(request.getTech().getContentType()))) {
            return ResponseEntity.internalServerError().build();
        }
        modelService.createModel(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }

    @PostMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
    public void editModel(EditModelRequest request, @PathVariable Long id) {
        modelService.editModel(id, request);
    }

}
