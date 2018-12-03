package category.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("")
    public String create(User user){
        loginRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/{id}")
    public String login_Form(Model model, @PathVariable Long id){

        model.addAttribute(loginRepository.findById(id).orElseGet(null));
        return "/index";
    }

}
