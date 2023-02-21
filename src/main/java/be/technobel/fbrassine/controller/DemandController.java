package be.technobel.fbrassine.controller;

import be.technobel.fbrassine.models.dto.DemandDTO;
import be.technobel.fbrassine.models.form.DemandForm;
import be.technobel.fbrassine.service.AuthService;
import be.technobel.fbrassine.service.DemandService;
import be.technobel.fbrassine.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demand")
public class DemandController {
    private final DemandService demandService;
    private final AuthService authService;
    private final RoomService roomService;

    public DemandController(DemandService demandService, AuthService authService, RoomService roomService) {
        this.demandService = demandService;
        this.authService = authService;
        this.roomService = roomService;
    }
    @GetMapping("/all")
    public String displayDemands(Model model){
        model.addAttribute("list", demandService.getAll());
        model.addAttribute("role", authService.getRoleConnected());
        return "demand/display-all";
    }
    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model, @PathVariable("id") long id){
        model.addAttribute("role", authService.getRoleConnected());
        model.addAttribute("demand", demandService.getOne(id));
        return "demand/display-one";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form", new DemandForm());
        model.addAttribute("list", demandService.getAll());
        model.addAttribute("role", authService.getRoleConnected());
        return "demand/insert-form";
    }
    @PostMapping("/add")
    public String processInsertForm(
            Model model,
            @ModelAttribute("form") @Valid DemandForm form,
            BindingResult bindingResult){
        if(bindingResult.hasErrors() ) {
            model.addAttribute("list", demandService.getAll());
            return "demand/insert-form";
        }
        demandService.addOne(form);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/demand/all";
    }
    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id){
        DemandForm form = new DemandForm();
        DemandDTO dto = demandService.getOne(id);
        form.setTerm(dto.getTerm());
        form.setTimeSlots(dto.getTimeSlots());
        model.addAttribute("role", authService.getRoleConnected());
        model.addAttribute("form", form);
        model.addAttribute("id", id);
        return "demand/update-form";
    }
    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            Model model,
            @PathVariable Long id,
            @ModelAttribute("form") @Valid DemandForm form,
            BindingResult bindingResult
    ){
        if( bindingResult.hasErrors() ){
            return "demand/update-form";
        }
        demandService.update(id, form);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/demand/all";
    }
    @PostMapping("/{id:[0-9]+}/delete")
    public String processRemoveForm(Model model, @PathVariable Long id){
        demandService.delete(id);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/demand/all";
    }
}
