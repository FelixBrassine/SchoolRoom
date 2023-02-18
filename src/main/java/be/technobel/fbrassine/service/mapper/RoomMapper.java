package be.technobel.fbrassine.service.mapper;

import be.technobel.fbrassine.models.dto.RoomDTO;
import be.technobel.fbrassine.models.entity.Room;
import be.technobel.fbrassine.models.form.RoomForm;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {
    public RoomDTO toDto(Room entity){

        if (entity == null){
            return null;
        }else {
            return RoomDTO.builder()
                    .id( entity.getId() )
                    .name( entity.getName() )
                    .numberPlaces( entity.getNumberPlaces() )
                    .teacherRoom( entity.isTeacherRoom() )
                    .build();
        }
    }
    public Room formToEntity(RoomForm form) {
        if (form == null){
            return null;
        }else{
            Room room = new Room();
            room.setName( form.getName() );
            room.setNumberPlaces(form.getNumberPlaces());
            room.setTeacherRoom(form.isTeacherRoom());
            return room;
        }
    }
}
