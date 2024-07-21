package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.specifications.Facts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactsRepository extends JpaRepository<Facts, Integer> {
}
