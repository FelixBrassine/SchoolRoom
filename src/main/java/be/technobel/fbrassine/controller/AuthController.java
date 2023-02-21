package be.technobel.fbrassine.controller;

import be.technobel.fbrassine.models.form.ConnectForm;
import be.technobel.fbrassine.models.form.RegisterForm;
import be.technobel.fbrassine.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("form") RegisterForm form){
        return "/auth/register-form";
    }

    @PostMapping("/register")
    public String processRegistration(
            Model model,
            @ModelAttribute("form") @Valid RegisterForm form,
            BindingResult bindingResult){
        if( bindingResult.hasErrors() ){
            form.setPassword(null);
            return "/auth/register-form";
        }
        authService.register(form);
        authService.roleConnected(form);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/auth/home";
    }

    @GetMapping("/connect")
    public String connectForm(@ModelAttribute("form") ConnectForm form){
        return "/auth/connect-form";
    }

    @PostMapping("/connect")
    public String processConnectForm(Model model,
            @ModelAttribute("form") @Valid ConnectForm form,
            BindingResult bindingResult){
        if( bindingResult.hasErrors() ){
            form.setPassword(null);
            return "/auth/connect-form";
        }
        authService.roleConnected(form);
        return "redirect:/auth/home";
    }
    @GetMapping("/logOut")
    public String logOut(){
        authService.deconnected();
        return "index";
    }
    @GetMapping("/home")
    public String displayHome(Model model){
        model.addAttribute("role", authService.getRoleConnected());
        return "auth/home";
    }
}
