package be.technobel.fbrassine.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name="\"user\"")
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "user_id", nullable = false)
    private long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String Login;
    @Column( nullable = false )
    private String name;
    @Column( nullable = false )
    private String firstName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String adress;
    @Column(nullable = false)
    private Role role;

    @OneToMany (mappedBy = "user")
    private Set<Demand> demands = new LinkedHashSet<>();
    @OneToOne(mappedBy="admin")
    private Demand demand;
}
