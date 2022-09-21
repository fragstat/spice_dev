package hse.project.spice.service;

import hse.project.spice.dto.RequestDto;

import java.util.List;

public interface RequestService {
    void createRequest(RequestDto dto);

    List<RequestDto> getRequestList();
}
