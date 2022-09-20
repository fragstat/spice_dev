package hse.project.spice.controller;

import hse.project.spice.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto dto) {
        boolean correct = "123456".equals(dto.getPassword()) && "admin".equals(dto.getLogin());
        return ResponseEntity.status(correct ? HttpStatus.OK : HttpStatus.UNAUTHORIZED).build();
    }


}
