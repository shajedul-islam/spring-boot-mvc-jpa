package com.uiu.cdip.springbootmvcjpa.controller;

import com.uiu.cdip.springbootmvcjpa.dao.UserDAO;
import com.uiu.cdip.springbootmvcjpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    // in earlier examples we used to return ModelAndView
    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        // if input error then keep in add-user page
        if (result.hasErrors()) {
            return "add-user";
        }
        // save user in db
        userDAO.save(user);

        List<User> users = (List<User>)userDAO.findAll();

        model.addAttribute("allUsers", users);
        return "index";
    }
}
