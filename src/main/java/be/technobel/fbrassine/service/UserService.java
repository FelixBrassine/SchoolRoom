package be.technobel.fbrassine.service;


public interface UserService {

    boolean checkEmailNotTaken(String email);
    boolean checkLoginNotTaken(String userLogin);
    boolean checkUserNotExist(String password, String email);

}
