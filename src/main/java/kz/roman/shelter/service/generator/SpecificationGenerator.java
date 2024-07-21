package kz.roman.shelter.service.generator;

import kz.roman.shelter.model.entity.specifications.*;
import kz.roman.shelter.model.enums.Sex;
import kz.roman.shelter.utils.RandomUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecificationGenerator {

    public Occupation generateOccupation(List<Occupation> availableOccupations) {
        int randomOccupationId = RandomUtil.generateRandomNumber(1, availableOccupations.size() - 1);

        Occupation generatedOccupation = availableOccupations.get(randomOccupationId);

        availableOccupations.remove(randomOccupationId);

        return generatedOccupation;
    }

    public Integer generateAge() {
        return RandomUtil.generateRandomNumber(18, 100);
    }

    public Health generateHealth() {
        int randomHealthId = RandomUtil.generateRandomNumber(1, PreloadService.healthList.size() -1);

        return PreloadService.healthList.get(randomHealthId);
    }

    public Sex generateSex() {
        int randomIndex = RandomUtil.generateRandomNumber(0, 1);

        return Sex.values()[randomIndex];
    }

    public Baggage generateBaggage(List<Baggage> availableBaggage) {
        int randomBaggageId = RandomUtil.generateRandomNumber(1, availableBaggage.size() - 1);

        Baggage generatedBaggage = availableBaggage.get(randomBaggageId);

        availableBaggage.remove(randomBaggageId);

        return generatedBaggage;
    }

    public Facts generateFact(List<Facts> availableFacts) {
        int randomFactId = RandomUtil.generateRandomNumber(1, availableFacts.size() - 1);

        Facts generatedFact = availableFacts.get(randomFactId);

        availableFacts.remove(randomFactId);

        return generatedFact;
    }

    public Phobia generatePhobia(List<Phobia> availablePhobias) {
        int randomPhobiaId = RandomUtil.generateRandomNumber(1, availablePhobias.size());

        Phobia generatedPhobia = availablePhobias.get(randomPhobiaId);

        availablePhobias.remove(randomPhobiaId);

        return generatedPhobia;
    }
}
