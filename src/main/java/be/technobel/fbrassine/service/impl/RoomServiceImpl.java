package be.technobel.fbrassine.service.impl;

import be.technobel.fbrassine.exceptions.NotFoundException;
import be.technobel.fbrassine.models.dto.RoomDTO;
import be.technobel.fbrassine.models.entity.Room;
import be.technobel.fbrassine.models.form.RoomForm;
import be.technobel.fbrassine.repository.RoomRepository;
import be.technobel.fbrassine.service.RoomService;
import be.technobel.fbrassine.service.mapper.RoomMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper mapper;
    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper mapper) {
        this.roomRepository = roomRepository;
        this.mapper = mapper;
    }

    @Override
    public RoomDTO getOne(Long id) {
        return roomRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow( () -> new NotFoundException("Room not found"));
    }
    @Override
    public List<RoomDTO> getAll() {
        return roomRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
    @Override
    public void addOne(RoomForm form) {
        if (form == null){
            throw new IllegalArgumentException("form should be not null");
        }else{
            Room entity = mapper.formToEntity(form);
            entity.setName( form.getName() );
            entity.setNumberPlaces( form.getNumberPlaces() );
            entity.setTeacherRoom( form.isTeacherRoom() );
            roomRepository.save(entity);
        }
    }
    @Override
    public void update(Long id, RoomForm form) {
        Room toUpdate = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Room not found"));

        toUpdate.setName( form.getName() );
        toUpdate.setNumberPlaces( form.getNumberPlaces() );
        toUpdate.setTeacherRoom( form.isTeacherRoom() );
        roomRepository.save(toUpdate);
    }
    @Override
    public void delete(Long id) {
        Room entity = roomRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Room not found")
                );
        roomRepository.delete(entity);
    }
}
