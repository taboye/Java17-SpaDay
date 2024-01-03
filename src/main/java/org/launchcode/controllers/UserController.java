package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String displayAddUserForm(){
        return "/user/add";

    }
    //Processing Form Submission 1
    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        //Processing Form Submission 2 & 3(Passwords  not match,render the user/add view template)
        if(!user.getPassword().equals(verify)){
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error","Passwords do not match.");
            return "/user/add";
        }
        UserData.add(user);
        model.addAttribute("user",user);
        model.addAttribute("users", UserData.getAll());
        //Passwords match, render the user/index view template
        return "/user/index";

    }
    //Bonus mission 1
    @GetMapping("/details/{id}")
    public String displayUserDetails(@PathVariable int id, Model model){
        model.addAttribute("user", UserData.getById(id));
        return "/user/details";

    }
}
