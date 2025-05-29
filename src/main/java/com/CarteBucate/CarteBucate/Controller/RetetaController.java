package com.CarteBucate.CarteBucate.Controller;

import com.CarteBucate.CarteBucate.Entity.Reteta;
import com.CarteBucate.CarteBucate.Service.RetetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class RetetaController {

    @Autowired
    RetetaService retetaService;

    @GetMapping("/lista")
    public String listaBucate(Model model){
        model.addAttribute("retete", retetaService.getAllReteta());
        return "ListaBucate.html";
    }

    @GetMapping("/form")
    public  String RetetaForm(Model model){
        model.addAttribute("reteta",new Reteta());
        return "RetetaForm";
    }
    @PostMapping("/save")
    public String RetetaSave(Reteta reteta) {
        retetaService.saveReteta(reteta);
        return ("redirect:/lista");
    }
    @GetMapping("/edit/{id}")
    public  String retetaEdit(Model model,@PathVariable UUID id){

        model.addAttribute("reteta",retetaService.getRetetaById(id));
        return "RetetaForm";

    }

    @GetMapping("/delete/{id}")
    public String deleteReteta(Model model, @PathVariable UUID id) {
        retetaService.deleteReteta(id);
        return "redirect:/lista";
    }
    @GetMapping("/search")
    public String searchRecipes(@RequestParam("query") String query, Model model) {
        List<Reteta> retete = retetaService.searchReteta(query);
        model.addAttribute("retete", retete);
        return "ListaBucate";  // Thymeleaf template
    }
    @GetMapping("/Meniu")
    public String Meniu ()
    {
        return "Meniu";
    }


}
