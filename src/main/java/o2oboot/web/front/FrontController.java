package o2oboot.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")

public class FrontController {
    @RequestMapping("/index")
    private String login(){
        return "index";
    }

}
