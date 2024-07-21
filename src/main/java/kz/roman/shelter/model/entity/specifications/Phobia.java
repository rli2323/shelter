package kz.roman.shelter.model.entity.specifications;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "phobia")
@Data
public class Phobia extends BaseSpecification {

}
