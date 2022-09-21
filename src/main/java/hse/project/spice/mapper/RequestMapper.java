package hse.project.spice.mapper;

import hse.project.spice.dto.RequestDto;
import hse.project.spice.model.Request;

public class RequestMapper {

    public static RequestDto toDto(Request request) {
        return new RequestDto(request.getFio(), request.getOrg(), request.getEmail(), request.getPhone(),
                request.getType(), request.getComment());
    }

    public static Request toEntity(RequestDto requestDto) {
        return Request.builder()
                .fio(requestDto.getFio())
                .org(requestDto.getOrg())
                .email(requestDto.getEmail())
                .phone(requestDto.getPhone())
                .type(requestDto.getType())
                .comment(requestDto.getComment())
                .build();
    }
}
