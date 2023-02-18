package be.technobel.fbrassine.service;

import be.technobel.fbrassine.models.dto.DemandDTO;
import be.technobel.fbrassine.models.form.DemandForm;

import java.util.List;

public interface DemandService {

    DemandDTO getOne(Long id);
    List<DemandDTO> getAll();
    void addOne(DemandForm form);
    void update(Long id, DemandForm form);
    void delete(Long id);
}
