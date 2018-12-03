package category.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public String create(User inputUser){
        User loginUser = userRepository.findByUserId(inputUser.getUserId()).orElseGet(null);

        if(loginUser.getPassword().equals(inputUser.getPassword())){
            return String.format("redirect:/users/%d", loginUser.getId());
        }

        return "/login";
    }

    @GetMapping("/{id}")
    public String login_Form(Model model, @PathVariable Long id){
        model.addAttribute("user", userRepository.findById(id).orElseGet(null));
        return "/";
    }

}
