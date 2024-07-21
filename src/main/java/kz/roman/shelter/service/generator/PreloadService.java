package kz.roman.shelter.service.generator;

import jakarta.annotation.PostConstruct;
import kz.roman.shelter.model.entity.specifications.*;
import kz.roman.shelter.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreloadService {

    private final OccupationRepository occupationRepository;
    private final HealthRepository healthRepository;
    private final BaggageRepository baggageRepository;
    private final FactsRepository factsRepository;
    private final PhobiaRepository phobiaRepository;

    public static List<Occupation> occupationList = new ArrayList<>();
    public static List<Health> healthList = new ArrayList<>();
    public static List<Baggage> baggageList = new ArrayList<>();
    public static List<Facts> factsList = new ArrayList<>();
    public static List<Phobia> phobiaList = new ArrayList<>();

    @PostConstruct
    public void preload() {
        occupationList = occupationRepository.findAll();
        healthList = healthRepository.findAll();
        baggageList = baggageRepository.findAll();
        factsList = factsRepository.findAll();
        phobiaList = phobiaRepository.findAll();
    }
}
