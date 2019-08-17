package com.learning.mpholo.sftpetclinic.controllers;

import com.learning.mpholo.sftpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets","","/vets/index","/vets/index.html","/vets.html"})
    public String listVets(Model model) {

        vetService.findAll().forEach(v-> System.out.println(v.getFirstName()+" "+v.getLastName()));
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
}
