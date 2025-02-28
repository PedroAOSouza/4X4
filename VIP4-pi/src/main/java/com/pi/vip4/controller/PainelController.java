package com.pi.vip4.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PainelController {

    @GetMapping("/")
    public String painel(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao painel de controle!");
        return "painel"; // Nome do arquivo HTML dentro de src/main/resources/templates/
    }
}
