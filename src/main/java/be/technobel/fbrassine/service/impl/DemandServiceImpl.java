package be.technobel.fbrassine.service.impl;

import be.technobel.fbrassine.exceptions.NotFoundException;
import be.technobel.fbrassine.models.dto.DemandDTO;
import be.technobel.fbrassine.models.entity.Demand;
import be.technobel.fbrassine.models.form.DemandForm;
import be.technobel.fbrassine.repository.DemandRepository;
import be.technobel.fbrassine.service.DemandService;
import be.technobel.fbrassine.service.mapper.DemandMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandServiceImpl implements DemandService {
    private final DemandRepository demandRepository;
    private final DemandMapper mapper;

    public DemandServiceImpl(DemandRepository demandRepository, DemandMapper mapper) {
        this.demandRepository = demandRepository;
        this.mapper = mapper;
    }

    @Override
    public DemandDTO getOne(Long id) {
        return demandRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow( () -> new NotFoundException("Demand not found"));
    }
    @Override
    public List<DemandDTO> getAll() {
        return demandRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
    @Override
    public void addOne(DemandForm form) {
        if (form == null){
            throw new IllegalArgumentException("form should be not null");
        }else{
            Demand entity = mapper.formToEntity(form);
            entity.setTerm( form.getTerm() );
            entity.setTimeSlots( form.getTimeSlots() );
            demandRepository.save(entity);
        }
    }
    @Override
    public void update(Long id, DemandForm form) {
        Demand toUpdate = demandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Demand not found"));
        toUpdate.setTerm( form.getTerm() );
        toUpdate.setTimeSlots( form.getTimeSlots() );
        demandRepository.save(toUpdate);
    }
    @Override
    public void delete(Long id) {
        Demand entity = demandRepository.findById(id)
                .orElseThrow( () -> new NotFoundException("Demand not found")
                );
        demandRepository.delete(entity);
    }
}
