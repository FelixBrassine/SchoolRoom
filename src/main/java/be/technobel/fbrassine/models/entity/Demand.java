package be.technobel.fbrassine.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Demand {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "demand_id", nullable = false)
    private long id;
    @Column( nullable = false )
    private LocalDateTime timeSlots;
    @Column( nullable = false )
    private int term;

    @ManyToOne
    @JoinColumn(name="room_id", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "admin_id")
    private User admin;
    @ManyToMany
    @JoinTable(
            name="demand_material",
            joinColumns = @JoinColumn(name = "demand_id"),
            inverseJoinColumns = @JoinColumn(name="material_id")
    )
    private Set<Material> materials = new LinkedHashSet<>();
}
