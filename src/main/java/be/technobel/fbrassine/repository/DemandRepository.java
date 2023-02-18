package be.technobel.fbrassine.repository;

import be.technobel.fbrassine.models.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand,Long> {
}
