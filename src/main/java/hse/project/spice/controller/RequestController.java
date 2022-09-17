package hse.project.spice.controller;

import hse.project.spice.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestController {

    @PostMapping
    public void createRequest(@RequestBody RequestDto dto) {

    }

}
