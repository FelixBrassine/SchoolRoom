package be.technobel.fbrassine.service.mapper;

import be.technobel.fbrassine.models.entity.User;
import be.technobel.fbrassine.models.form.RegisterForm;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toEntity(RegisterForm form){
        if( form == null )
            return null;

        User user = new User();
        user.setEmail( form.getEmail() );
        user.setPassword( form.getPassword() );
        user.setLogin(form.getLogin());
        user.setName(form.getName());
        user.setFirstName( form.getFirstName() );
        user.setPhoneNumber( form.getPhoneNumber() );
        user.setAdress( form.getAdress() );
        user.setRole( form.getRole() );
        return user;
    }

}
