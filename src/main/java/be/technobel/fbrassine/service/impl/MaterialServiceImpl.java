package be.technobel.fbrassine.service.impl;

import be.technobel.fbrassine.exceptions.NotFoundException;
import be.technobel.fbrassine.models.dto.MaterialDTO;
import be.technobel.fbrassine.models.entity.Material;
import be.technobel.fbrassine.models.form.MaterialForm;
import be.technobel.fbrassine.repository.MaterialRepository;
import be.technobel.fbrassine.service.MaterialService;
import be.technobel.fbrassine.service.mapper.MaterialMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper mapper;
    public MaterialServiceImpl(MaterialRepository materialRepository, MaterialMapper mapper) {
        this.materialRepository = materialRepository;
        this.mapper = mapper;
    }

    @Override
    public MaterialDTO getOne(Long id) {
        return materialRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow( () -> new NotFoundException("Material not found"));
    }
    @Override
    public List<MaterialDTO> getAll() {
        return materialRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
    @Override
    public void addOne(MaterialForm form) {
        if (form == null){
            throw new IllegalArgumentException("form should be not null");
        }else{
            Material entity = mapper.formToEntity(form);
            entity.setName(form.getName());
            materialRepository.save(entity);
        }
    }
    @Override
    public void update(Long id, MaterialForm form) {
        Material toUpdate = materialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material not found"));

        toUpdate.setName( form.getName() );
        materialRepository.save(toUpdate);
    }
    @Override
    public void delete(Long id) {
        Material entity = materialRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Sandwich not found")
                );
        materialRepository.delete(entity);
    }
}
