package hse.project.spice.service.impl;

import hse.project.spice.dto.RequestDto;
import hse.project.spice.mapper.RequestMapper;
import hse.project.spice.repository.RequestRepository;
import hse.project.spice.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Override
    public void createRequest(RequestDto dto) {
        requestRepository.save(RequestMapper.toEntity(dto));
    }

    @Override
    public List<RequestDto> getRequestList() {
        return requestRepository.findAll().stream()
                .map(RequestMapper::toDto)
                .toList();
    }

}
