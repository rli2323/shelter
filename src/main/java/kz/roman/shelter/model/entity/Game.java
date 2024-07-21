package kz.roman.shelter.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "game")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    private UUID id;

    @Column(name = "code")
    private String code;

    @CreationTimestamp
    @Column(name = "created_date", columnDefinition = "timestamp")
    private LocalDateTime createdDate;

    @Column(name = "end_date", columnDefinition = "timestamp")
    private LocalDateTime endDate;

    @Column(name = "is_finished", columnDefinition = "boolean default false")
    private Boolean isFinished;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @Column(name = "players_number")
    private Integer playersNumber;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Character> characterList;
}
