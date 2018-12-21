package category.contact;

import category.security.HttpSessionUtils;
import category.login.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping("")
    public String contact(HttpSession session, Contact contact) {

        User user = HttpSessionUtils.getUserFromSession(session);

        if (user != null) {
            contactRepository.save(contact);
            return "redirect:/contacts/contactInput";
        }

        return "index";
    }

    @GetMapping("/contactInput")
    public String contactInput(Model model) {
        model.addAttribute("input", contactRepository.findAll());
        return "/category/contact";
    }

    @GetMapping("/{id}/modify")
    public String modify(@PathVariable long id, Model model, HttpSession session) {
        //접근 전 로그인 유저 확인할 것

        User  user = HttpSessionUtils.getUserFromSession(session);
        Contact contact = contactRepository.findById(id).orElseGet(null);

        model.addAttribute("modifyInput", contact);
        return "/category/contact_modify";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable long id, String name, String messages){

        Contact contact = contactRepository.findById(id).orElseGet(null);

        contact.update(name, messages);
        contactRepository.save(contact);

        return "redirect:/contacts/contactInput";
    }
}


