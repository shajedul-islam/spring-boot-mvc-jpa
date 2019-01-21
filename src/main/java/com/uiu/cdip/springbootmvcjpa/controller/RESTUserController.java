package com.uiu.cdip.springbootmvcjpa.controller;

import com.uiu.cdip.springbootmvcjpa.dao.UserDAO;
import com.uiu.cdip.springbootmvcjpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RESTUserController {

    @Autowired
    UserDAO userDAO;

    @GetMapping
    public String doSomething() {
        return "<h1>users restful api</h1>";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public User getUser(@RequestParam(value = "email") String email) {
        /*User user = new User();
        user.setEmail("someone@example.com");
        user.setName("Someone");
*/
        return userDAO.findByEmail(email);
    }

}
