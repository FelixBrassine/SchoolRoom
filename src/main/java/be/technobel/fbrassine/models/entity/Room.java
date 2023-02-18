package be.technobel.fbrassine.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Room {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "romm_id", nullable = false)
    private long id;
    @Column( nullable = false )
    private String name;
    @Column( nullable = false )
    private int numberPlaces;
    @Column( nullable = false )
    private boolean teacherRoom;
    @OneToMany (mappedBy = "room")
    private Set<Demand> demands = new LinkedHashSet<>();
    @ManyToMany
    @JoinTable(
            name="room_material",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name="material_id")
    )
    private Set<Material> materials = new LinkedHashSet<>();
}
