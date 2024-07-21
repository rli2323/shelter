package kz.roman.shelter.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kz.roman.shelter.model.entity.specifications.*;
import kz.roman.shelter.model.enums.Sex;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "character")
@Data
public class Character {

    @Id
    private UUID id;

    @Column(name = "player_name")
    private String playerName;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private Occupation occupation;

    @ManyToOne
    @JoinColumn(name = "health_id")
    private Health health;

    @Enumerated
    private Sex sex;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

    @ManyToOne
    @JoinColumn(name = "fact_id")
    private Facts fact;

    @ManyToOne
    @JoinColumn(name = "phobia_id")
    private Phobia phobia;

    @ManyToOne
    @JoinColumn(name = "baggage_id")
    private Baggage baggage;
}
