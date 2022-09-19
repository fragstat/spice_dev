package hse.project.spice.controller;

import hse.project.spice.dto.CreateModelRequest;
import hse.project.spice.dto.ModelDto;
import hse.project.spice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping
    public List<ModelDto> getModels() {
        return modelService.getModelList();
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> createModel(CreateModelRequest request) {
        if (!request.getTech().getContentType().equals(MediaType.APPLICATION_PDF_VALUE) ||
                !request.getLink().getContentType().equals(MediaType.APPLICATION_PDF_VALUE)) {
            return ResponseEntity.badRequest().build();
        }
        modelService.createModel(request);
        return ResponseEntity.ok().build();
    }

}
