package be.technobel.fbrassine.repository;

import be.technobel.fbrassine.models.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
