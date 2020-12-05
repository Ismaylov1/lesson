package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
//    public String getIndex(){
//        return "index";
//    }
    public String listUsers(Model mod) {
        mod.addAttribute("user", new User());
        mod.addAttribute("listbooks", this.userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            this.userService.add(user);
        } else {
            this.userService.updateUsers(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        this.userService.remove(id);
        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";
    }

}

