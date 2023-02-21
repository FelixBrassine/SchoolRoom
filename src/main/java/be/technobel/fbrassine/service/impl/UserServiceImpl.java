package be.technobel.fbrassine.service.impl;

import be.technobel.fbrassine.repository.UserRepository;
import be.technobel.fbrassine.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkEmailNotTaken(String email){
        return !userRepository.existsByEmail(email);
    }
    @Override
    public boolean checkLoginNotTaken(String userLogin) {
        return !userRepository.existsByUserLogin(userLogin);
    }

    @Override
    public boolean checkUserNotExist(String password, String userLogin) {
        return userRepository.existsByPasswordAndUserLogin(password, userLogin);
    }

}
