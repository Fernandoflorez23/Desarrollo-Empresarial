package com.usta.empresarialfull.controllers;

import com.usta.empresarialfull.entities.universidadEntity;
import com.usta.empresarialfull.models.services.IuniversidadService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class universidadController {
    @Autowired
    private IuniversidadService iuniversidadService;

    @GetMapping("/HolaMundo")
    public String test(){
        return "HolaMundo";
    }

    @GetMapping("listarUniversidades")
    public String listarUniversidad(Model model){
        model.addAttribute("titulo","Listado de Universidades");
        model.addAttribute("universidades",iuniversidadService.findAll());
        return "listarUniversidades";
    }

    @GetMapping("crearUniversidad")
    public String crearUniversidad(Model model){
        model.addAttribute("titulo","Crear Universidad");
        model.addAttribute("universidad", new universidadEntity());
        return "crearUniversidad";
    }

    @PostMapping(value = "crearUniversidad")
    public String guardadUniversidad(@Valid universidadEntity universidad,
                                     BindingResult result, SessionStatus status){
        if(result.hasErrors()){
            return "error500";
        }
        universidad.setEstado(true);
        iuniversidadService.save(universidad);
        status.setComplete();
        return "redirect:/listarUnivsersidad";
    }
}
