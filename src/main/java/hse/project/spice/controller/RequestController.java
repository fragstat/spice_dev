package hse.project.spice.controller;

import hse.project.spice.dto.RequestDto;
import hse.project.spice.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public void createRequest(@RequestBody RequestDto dto) {
        requestService.createRequest(dto);
    }

    @GetMapping
    public List<RequestDto> getRequestList() {
        return requestService.getRequestList();
    }

}
