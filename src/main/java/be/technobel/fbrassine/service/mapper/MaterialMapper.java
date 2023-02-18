package be.technobel.fbrassine.service.mapper;

import be.technobel.fbrassine.models.form.MaterialForm;
import be.technobel.fbrassine.models.dto.MaterialDTO;
import be.technobel.fbrassine.models.entity.Material;
import org.springframework.stereotype.Service;

@Service
public class MaterialMapper {
    public MaterialDTO toDto(Material entity){

        if (entity == null){
            return null;
        }else {
            return MaterialDTO.builder()
                    .id( entity.getId() )
                    .name( entity.getName() )
                    .build();
        }
    }
    public Material formToEntity(MaterialForm form) {
        if (form == null){
            return null;
        }else{
            Material material = new Material();
            material.setName( form.getName() );
            return material;
        }
    }
}
