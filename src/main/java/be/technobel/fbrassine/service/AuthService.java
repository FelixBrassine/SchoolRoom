package be.technobel.fbrassine.service;

import be.technobel.fbrassine.models.dto.UserConnectedDTO;
import be.technobel.fbrassine.models.form.ConnectForm;
import be.technobel.fbrassine.models.form.RegisterForm;

public interface AuthService {

    void register(RegisterForm form);
    void roleConnected(ConnectForm form);
    void roleConnected(RegisterForm form);
    public void deconnected();
    Integer getRoleConnected();
}
