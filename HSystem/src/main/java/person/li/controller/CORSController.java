package person.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CORSController {

    @RequestMapping(value = "/getCORSpage")
    public String getCORSpage(){
        return "corstest";
    }
}
