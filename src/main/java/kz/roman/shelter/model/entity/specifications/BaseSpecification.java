package kz.roman.shelter.model.entity.specifications;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Data
@ToString
public class BaseSpecification {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;
}
