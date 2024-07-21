package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.specifications.Phobia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhobiaRepository extends JpaRepository<Phobia, Integer> {
}
