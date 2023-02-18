package be.technobel.fbrassine.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Material {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "material_id", nullable = false)
    private long id;
    @Column( nullable = false )
    private String name;

    @ManyToMany
    private Set<Demand> demands = new LinkedHashSet<>();
    @ManyToMany
    private Set<Room> rooms = new LinkedHashSet<>();
}
