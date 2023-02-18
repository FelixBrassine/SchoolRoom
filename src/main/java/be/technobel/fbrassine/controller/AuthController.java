package be.technobel.fbrassine.controller;

import be.technobel.fbrassine.models.entity.Role;
import be.technobel.fbrassine.models.form.ConnectForm;
import be.technobel.fbrassine.models.form.RegisterForm;
import be.technobel.fbrassine.repository.UserRepository;
import be.technobel.fbrassine.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService,
                          UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("form") RegisterForm form){
        return "/auth/register-form";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("form") @Valid RegisterForm form, BindingResult bindingResult){
        if( bindingResult.hasErrors() ){
            form.setPassword(null);
            return "/auth/register-form";
        }
        authService.register(form);
        return "redirect:/";
    }

    @GetMapping("/connect")
    public String connectForm(@ModelAttribute("form") ConnectForm form){
        return "/auth/connect-form";
    }

    @PostMapping("/connect")
    public String processConnectForm(
            @ModelAttribute("form") @Valid ConnectForm form,
            BindingResult bindingResult){
        if( bindingResult.hasErrors() ){
            form.setPassword(null);
            return "/auth/connect-form";
        }
        Role role = userRepository.findByPasswordAndEmail(form.getPassword(), form.getEmail()).getRole();
        switch (role){
            case ADMIN :
                return "demand/admin/insert-form";
            case TEACHER:
                return "demand/teacher/insert-form";
            case STUDENT:
                return "demand/student/insert-form";
        }
        return "auth/connect-form";
    }
}
