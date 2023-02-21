package be.technobel.fbrassine.service.impl;

import be.technobel.fbrassine.models.dto.UserConnectedDTO;
import be.technobel.fbrassine.models.entity.User;
import be.technobel.fbrassine.models.form.ConnectForm;
import be.technobel.fbrassine.models.form.RegisterForm;
import be.technobel.fbrassine.repository.UserRepository;
import be.technobel.fbrassine.service.AuthService;
import be.technobel.fbrassine.service.mapper.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserConnectedDTO userConnectedDTO = new UserConnectedDTO();
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

    @Override
    public void roleConnected(ConnectForm form) {
        userConnectedDTO.setRole( userRepository.findByPasswordAndUserLogin(form.getPassword(), form.getUserLogin()).getRole());
    }

    @Override
    public void roleConnected(RegisterForm form) {
        userConnectedDTO.setRole( userRepository.findByPasswordAndUserLogin(form.getPassword(), form.getUserLogin()).getRole());
    }

    @Override
    public void deconnected(){
        userConnectedDTO.setRole(null);
    }

    @Override
    public Integer getRoleConnected() {
        return userConnectedDTO.getRole().ordinal();
    }
}
