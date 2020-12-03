package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }
    @RequestMapping("/welcome")
    public String Welcome(){
        return "welcome";
    }
}
