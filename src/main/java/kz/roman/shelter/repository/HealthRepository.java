package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.specifications.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<Health, Integer> {
}
