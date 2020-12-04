package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping("")
    public String getIndex(){
        return "index";
    }
    @RequestMapping("/welcome")
    public String Welcome(){
        return "welcome";
    }
}
