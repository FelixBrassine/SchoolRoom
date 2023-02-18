package be.technobel.fbrassine.service.impl;

import be.technobel.fbrassine.models.entity.User;
import be.technobel.fbrassine.models.form.RegisterForm;
import be.technobel.fbrassine.repository.UserRepository;
import be.technobel.fbrassine.service.AuthService;
import be.technobel.fbrassine.service.mapper.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void register(RegisterForm form) {

        User user = userMapper.toEntity(form);
        userRepository.save( user );
    }


}
