package kz.roman.shelter.model.dto;

import kz.roman.shelter.model.enums.Sex;
import lombok.Data;

@Data
public class CharacterDto {

    private String occupation;
    private Sex sex;
    private Integer age;
    private String health;
    private String baggage;
    private String fact;
    private String phobia;


}
