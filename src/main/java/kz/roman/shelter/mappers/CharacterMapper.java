package kz.roman.shelter.mappers;

import kz.roman.shelter.model.dto.CharacterDto;
import kz.roman.shelter.model.entity.Character;


public class CharacterMapper {

    public static CharacterDto characterToDto(Character entity) {
        CharacterDto dto = new CharacterDto();

        dto.setOccupation(entity.getOccupation().getName());
        dto.setHealth(entity.getHealth().getName());
        dto.setSex(entity.getSex());
        dto.setAge(entity.getAge());
        dto.setBaggage(entity.getBaggage().getName());
        dto.setFact(entity.getFact().getName());
        dto.setPhobia(entity.getPhobia().getName());

        return dto;
    }
}
