package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.specifications.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Integer> {
}
