package kz.roman.shelter.model.entity.specifications;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "catastrophe")
@Data
public class Catastrophe extends BaseSpecification {

    @Column(name = "description", columnDefinition = "text")
    private String description;
}
