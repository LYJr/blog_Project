package category.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("")
    public String login_Form(){

        return "/category/login";
    }

}
