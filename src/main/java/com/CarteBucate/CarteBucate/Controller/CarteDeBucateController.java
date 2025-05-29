package com.CarteBucate.CarteBucate.Controller;

import com.CarteBucate.CarteBucate.Entity.CarteDeBucate;
import com.CarteBucate.CarteBucate.Entity.Reteta;
import com.CarteBucate.CarteBucate.Service.CarteDeBucateService;
import com.CarteBucate.CarteBucate.Service.RetetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarteDeBucateController {

    @Autowired
    CarteDeBucateService carteDeBucateService;

    @Autowired
    RetetaService retetaService;

    @GetMapping("/listaCarti")
    public String listaCarti(Model model){
        model.addAttribute("carti",carteDeBucateService.getAllCarteDeBucate());
        return "ListaCarti";
    }

    @GetMapping("/formCarte")
    public String formCarte(Model model){
        model.addAttribute("retete",retetaService.getAllReteta());
        model.addAttribute("carteDeBucate",new CarteDeBucate());
        return "CarteForm";
    }
    @PostMapping("/saveCarte")
    public String saveCarte(CarteDeBucate carteDeBucate){
        carteDeBucateService.saveCarteDeBucate(carteDeBucate);
        return ("redirect:/listaCarti");
    }
    @GetMapping("/searchCarte")
    public String searchRecipes(@RequestParam("query") String query, Model model) {
        List<CarteDeBucate> carti = carteDeBucateService.searchCarteDeBucate(query);
        model.addAttribute("carti", carti);
        return "ListaCarti";  // Thymeleaf template
    }
}
