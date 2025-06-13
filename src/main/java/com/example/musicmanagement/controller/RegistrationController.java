package com.example.musicmanagement.controller;

 import com.example.musicmanagement.form.UserForm;
 import com.example.musicmanagement.service.UserService;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
 public class RegistrationController {
    private final UserService userService;
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(UserForm userForm, Model model, RedirectAttributes redirectAttributes){
        List<String> errors = new ArrayList<>();
        
        if(userForm.getUsername()  == null || userForm.getUsername().trim().isEmpty()){
            errors.add("ユーザ名は必須です");
        }

        if(userForm.getPassword() == null || userForm.getPassword().trim().isEmpty()){
            errors.add("パスワードは必須です");
        }

        if(!errors.isEmpty()){
            model.addAttribute("errors",errors);
            model.addAttribute("userForm",userForm);
             return  "register";
        }

       //登録処理
       userService.createUser(userForm);

       redirectAttributes.addFlashAttribute("successMessage","ユーザ登録が完了しました！");
        return "redirect:/list";
    }
 }