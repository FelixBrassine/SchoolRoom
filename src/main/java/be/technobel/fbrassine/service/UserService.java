package be.technobel.fbrassine.service;


public interface UserService {

    boolean checkEmailNotTaken(String email);
    boolean userExist(String password, String email);

}
