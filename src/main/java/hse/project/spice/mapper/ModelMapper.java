package hse.project.spice.mapper;

import hse.project.spice.dto.ModelDto;
import hse.project.spice.model.ModelEntity;

public class ModelMapper {

    public static ModelDto toDto(ModelEntity model) {
        return ModelDto.builder()
                .name(model.getName())
                .manufacturer(model.getManufacturer())
                .maxU(model.getMaxU())
                .maxI(model.getMaxI())
                .maxProbU(model.getMaxProbU())
                .maxP(model.getMaxP())
                .box(model.getBox())
                .link(model.getLink())
                .techLink(model.getTechLink())
                .useConditions(model.getUseConditions())
                .build();
    }
}
