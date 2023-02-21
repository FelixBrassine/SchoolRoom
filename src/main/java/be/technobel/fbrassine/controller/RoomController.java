package be.technobel.fbrassine.controller;

import be.technobel.fbrassine.models.dto.RoomDTO;
import be.technobel.fbrassine.models.form.RoomForm;
import be.technobel.fbrassine.service.AuthService;
import be.technobel.fbrassine.service.MaterialService;
import be.technobel.fbrassine.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final AuthService authService;
    private final MaterialService materialService;


    public RoomController(RoomService roomService, AuthService authService, MaterialService materialService) {
        this.roomService = roomService;
        this.authService = authService;
        this.materialService = materialService;
    }
    @GetMapping("/all")
    public String displayRooms(Model model){
        model.addAttribute("list", roomService.getAll());
        model.addAttribute("role", authService.getRoleConnected());
        return "room/display-all";
    }
    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model, @PathVariable("id") long id){
        model.addAttribute("role", authService.getRoleConnected());
        model.addAttribute("room", roomService.getOne(id));
        return "room/display-one";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form", new RoomForm());
        model.addAttribute("list", roomService.getAll());
        model.addAttribute("role", authService.getRoleConnected());
        model.addAttribute("materials", materialService.getAll());
        return "room/insert-form";
    }
    @PostMapping("/add")
    public String processInsertForm(
            Model model,
            @ModelAttribute("form") @Valid RoomForm form,
            BindingResult bindingResult){
        if(bindingResult.hasErrors() ) {
            model.addAttribute("list", roomService.getAll());
            model.addAttribute("materials", materialService.getAll());
            return "room/insert-form";
        }
        roomService.addOne(form);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/room/all";
    }
    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id){
        RoomForm form = new RoomForm();
        RoomDTO dto = roomService.getOne(id);
        form.setName( dto.getName() );
        form.setNumberPlaces( dto.getNumberPlaces() );
        form.setTeacherRoom( dto.isTeacherRoom() );
        model.addAttribute("role", authService.getRoleConnected());
        model.addAttribute("form", form);
        model.addAttribute("id", id);
        model.addAttribute("materials", materialService.getAll());
        return "room/update-form";
    }
    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            Model model,
            @PathVariable Long id,
            @ModelAttribute("form") @Valid RoomForm form,
            BindingResult bindingResult
    ){
        if( bindingResult.hasErrors() ){
            model.addAttribute("materials", materialService.getAll());
            return "room/update-form";
        }
        roomService.update(id, form);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/room/all";
    }
    @PostMapping("/{id:[0-9]+}/delete")
    public String processRemoveForm(Model model, @PathVariable Long id){
        roomService.delete(id);
        model.addAttribute("role", authService.getRoleConnected());
        return "redirect:/room/all";
    }
}
