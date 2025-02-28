package com.pi.vip4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pi.vip4.model.User;
import com.pi.vip4.repository.UserRepository;

@Controller
public class LoginUserController {

    @Autowired
    private UserRepository userRepository; // Injeta o repositório

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao sistema de usuários! Faça login para continuar.");
        return "login-user"; // Renderiza a página de login
    }

    @PostMapping("/login")
    public String loginUser(String email, String senha, Model model) {
        User user = userRepository.findByEmail(email); // Busca o usuário pelo email
        if (user != null && user.getSenha().equals(senha)) { // Verifica se o email e senha coincidem
            return "redirect:/painel"; // Redireciona para o painel
        } else {
            model.addAttribute("erro", "Email ou senha incorretos.");
            return "login-user"; // Retorna para a página de login
        }
    }
}
