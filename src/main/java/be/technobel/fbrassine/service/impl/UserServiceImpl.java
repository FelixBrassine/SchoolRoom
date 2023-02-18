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
    public boolean userExist(String password, String email) {
        return userRepository.existsByPasswordAndEmail(password, email);
    }

}
