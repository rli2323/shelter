package kz.roman.shelter.model.entity.specifications;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "health")
@Data
public class Health extends BaseSpecification {


}
