package be.technobel.fbrassine.service;

import be.technobel.fbrassine.models.dto.MaterialDTO;
import be.technobel.fbrassine.models.form.MaterialForm;

import java.util.List;

public interface MaterialService {

    MaterialDTO getOne(Long id);
    List<MaterialDTO> getAll();
    void addOne(MaterialForm form);
    void update(Long id, MaterialForm form);
    void delete(Long id);
}
