package be.technobel.fbrassine.service;

import be.technobel.fbrassine.models.dto.RoomDTO;
import be.technobel.fbrassine.models.form.RoomForm;

import java.util.List;

public interface RoomService {

    RoomDTO getOne(Long id);
    List<RoomDTO> getAll();
    void addOne(RoomForm form);
    void update(Long id, RoomForm form);
    void delete(Long id);
}