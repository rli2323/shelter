package kz.roman.shelter.repository;

import kz.roman.shelter.model.entity.specifications.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Integer> {

}
