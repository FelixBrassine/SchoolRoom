package be.technobel.fbrassine.controller;

import be.technobel.fbrassine.service.DemandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demand")
public class DemandController {
    private final DemandService demandService;

    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }
    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model, @PathVariable("id") long id){
        model.addAttribute("material", demandService.getOne(id));
        return "material/display-one";
    }
//    @GetMapping("/")
}
