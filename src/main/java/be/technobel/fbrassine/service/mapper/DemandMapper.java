package be.technobel.fbrassine.service.mapper;

import be.technobel.fbrassine.models.dto.DemandDTO;
import be.technobel.fbrassine.models.entity.Demand;
import be.technobel.fbrassine.models.form.DemandForm;
import org.springframework.stereotype.Service;

@Service
public class DemandMapper {
    public DemandDTO toDto(Demand entity){

        if (entity == null){
            return null;
        }else {
            return DemandDTO.builder()
                    .id( entity.getId() )
                    .term(entity.getTerm())
                    .timeSolts( entity.getTimeSlots())
                    .build();
        }
    }
    public Demand formToEntity(DemandForm form) {
        if (form == null){
            return null;
        }else{
            Demand demand = new Demand();
            demand.setTerm( form.getTerm() );
            demand.setTimeSlots( form.getTimeSolts() );
            return demand;
        }
    }
}
