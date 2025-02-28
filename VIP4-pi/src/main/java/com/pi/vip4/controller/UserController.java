package com.pi.vip4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pi.vip4.model.User;
import com.pi.vip4.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder; // Injetando o PasswordEncoder

  // Exibe a lista de usuários
  @GetMapping
  public String getAllUsers(Model model) {
    List<User> users = userRepository.findAll();
    model.addAttribute("users", users);
    return "user-list"; // Nome do arquivo HTML em src/main/resources/templates/
  }

  // Exibe formulário para adicionar novo usuário
  @GetMapping("/new")
  public String showCreateUserForm(Model model) {
    model.addAttribute("user", new User()); // Cria um novo usuário vazio
    return "create-user-form"; // Formulário para criar usuário
  }

  // Salva um novo usuário
  @PostMapping("/save")
  public String createUser(@Valid @ModelAttribute User user) {
    // Criptografa a senha antes de salvar
    user.setSenha(passwordEncoder.encode(user.getSenha())); // Usando o passwordEncoder injetado
    userRepository.save(user);
    return "redirect:/users"; // Redireciona para a lista
  }

  // Exibe formulário para editar um usuário existente
  @GetMapping("/edit/{id}")
  public String showUpdateUserForm(@PathVariable("id") Long userId, Model model) throws Exception {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new Exception("Usuário não encontrado: " + userId));
    model.addAttribute("user", user);
    return "edit-user-form"; // Formulário para editar usuário
  }

  // Atualiza um usuário existente
  @PostMapping("/update/{id}")
  public String updateUser(@PathVariable("id") Long userId, @Valid @ModelAttribute User userDetails)
      throws Exception {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new Exception("Usuário não encontrado: " + userId));

    // Atualiza os dados do usuário
    user.setNome(userDetails.getNome());
    user.setSenha(passwordEncoder.encode(userDetails.getSenha())); // Criptografa a senha
    user.setTipo(userDetails.getTipo());
    user.setStatus(userDetails.isStatus()); // Atualiza o status

    userRepository.save(user);
    return "redirect:/users"; // Redireciona para a lista
  }

  // Deleta um usuário
  @GetMapping("/delete/{id}")
  public String deleteUser(@PathVariable("id") Long userId) throws Exception {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new Exception("Usuário não encontrado: " + userId));

    userRepository.delete(user);
    return "redirect:/users"; // Redireciona para a lista
  }
}
