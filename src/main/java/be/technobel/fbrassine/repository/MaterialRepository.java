package be.technobel.fbrassine.repository;

import be.technobel.fbrassine.models.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository  extends JpaRepository<Material,Long> {
}
