package hse.project.spice.controller;

import hse.project.spice.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final MinioService minioService;

    @GetMapping("/{id}")
    public void getFile(@PathVariable UUID id, HttpServletResponse response) {
        try {
            response.setContentType(MediaType.APPLICATION_PDF_VALUE);
            IOUtils.copy(minioService.getFile(id), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
