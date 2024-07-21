package kz.roman.shelter.model;

import kz.roman.shelter.model.entity.specifications.Baggage;
import kz.roman.shelter.model.entity.specifications.Facts;
import kz.roman.shelter.model.entity.specifications.Occupation;
import kz.roman.shelter.model.entity.specifications.Phobia;
import kz.roman.shelter.service.generator.PreloadService;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AvailableSpecifications {

    private List<Occupation> availableOccupations;
    private List<Baggage> availableBaggage;
    private List<Facts> availableFacts;
    private List<Phobia> availablePhobia;

    public static AvailableSpecifications getAvailableSpecifications() {
        return AvailableSpecifications.builder()
                .availableOccupations(PreloadService.occupationList)
                .availableBaggage(PreloadService.baggageList)
                .availableFacts(PreloadService.factsList)
                .availablePhobia(PreloadService.phobiaList)
                .build();
    }
}
