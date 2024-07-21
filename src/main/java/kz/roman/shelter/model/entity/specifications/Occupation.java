package kz.roman.shelter.model.entity.specifications;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "occupation")
public class Occupation extends BaseSpecification {


    @Override
    public String toString() {
        return "Профессия=" + getName();
    }
}
