package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class HomeController {
//    @Autowired
//    private UserService userService;
//
//
//
//    @GetMapping
//    public String listUsers(Model mod) {
//        mod.addAttribute("users", userService.listUsers());
//
//        return "users";
//    }
//
//    @GetMapping("/add")
//    public String getUserForm() {
//        return "userAdd";
//    }

//    @PostMapping("/add")
//    public String addUsers(@ModelAttribute("user") User user) {
//        if (user.getId() == 0) {
//            this.userService.add(user);
//        } else {
//            this.userService.updateUsers(user);
//        }
//        return "redirect:/users";
//    }
//@PostMapping("/add")
//public String addUser(@ModelAttribute("addUser") User user) {
//    userService.add(user);
//    return "redirect:/users";
//}
//    @GetMapping("/remove/{id}")
//    public String removeUser(@PathVariable("id") long id) {
//        this.userService.remove(id);
//        return "redirect:/users";
//    }
//    @PostMapping("/edit/{id}")
//    public String updateUser(@ModelAttribute("editUser") User user) {
//        userService.updateUser(user);
//        return "redirect:/users";
//    }
//    @PostMapping("edit/{id}")
//    public String editUser(@PathVariable("id") long id, Model model) {
//        model.addAttribute("editUser", this.userService.getUserById(id));
////        model.addAttribute("listUsers", this.userService.listUsers());
//
//        return "editUsers";
//    }
//
////    @RequestMapping("userdata/{id}")
////    public String userData(@PathVariable("id") long id, Model model) {
////        model.addAttribute("user", this.userService.getUserById(id));
////        return "userdata";
////    }
    @Autowired
    private UserService userService;

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.listUsers());
        List<User> users = userService.listUsers();
        for (User user: users
             ) {
            System.out.println(user);

        }
        return "users";
    }
    @GetMapping("/add")
    public String getUserForm() {
        return "userAdd";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute("addUser") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("editUser", userService.getUserById(id));
        return "editUsers";
    }
    @PostMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("editUser") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.remove(id);
        return "redirect:/users";
    }
}

