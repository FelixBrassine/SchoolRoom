package be.technobel.fbrassine.controller;

import be.technobel.fbrassine.service.MaterialService;
import be.technobel.fbrassine.models.form.MaterialForm;
import be.technobel.fbrassine.models.dto.MaterialDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/material")
public class MaterialController {
    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/all")
    public String displayMaterials(Model model){
        model.addAttribute("list", materialService.getAll());
        return "material/display-all";
    }
    @GetMapping("/{id:[0-9]+}")
    public String getOne(Model model, @PathVariable("id") long id){
        model.addAttribute("material", materialService.getOne(id));
        return "material/display-one";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        model.addAttribute("form", new MaterialForm());
        model.addAttribute("list", materialService.getAll());
        return "material/insert-form";
    }
    @PostMapping("/add")
    public String processInsertForm(
            Model model,
            @ModelAttribute("form") @Valid MaterialForm form,
            BindingResult bindingResult){
        if(bindingResult.hasErrors() ) {
            model.addAttribute("list", materialService.getAll());
            return "material/insert-form";
        }materialService.addOne(form);
        return "redirect:/material/all";
    }
    @GetMapping("/{id:[0-9]+}/update")
    public String updateForm(Model model, @PathVariable long id){
        MaterialForm form = new MaterialForm();
        MaterialDTO dto = materialService.getOne(id);
        form.setName( dto.getName() );
        model.addAttribute("form", form);
        model.addAttribute("id", id);
        return "material/update-form";
    }
    @PostMapping("/{id:[0-9]+}/update")
    public String processUpdateForm(
            @PathVariable Long id,
            @ModelAttribute("form") @Valid MaterialForm form,
            BindingResult bindingResult
    ){
        if( bindingResult.hasErrors() ){
            return "material/update-form";
        }
        materialService.update(id, form);
        return "redirect:/material/all";
    }
    @PostMapping("/{id:[0-9]+}/delete")
    public String processRemoveForm(@PathVariable Long id){
        materialService.delete(id);
        return "redirect:/material/all";
    }
}
