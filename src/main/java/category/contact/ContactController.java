package category.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @PostMapping("")
    public String contact(Contact contact){
        System.out.println("확인해보자"+ contact);
        contactRepository.save(contact);
        return "redirect:/contactInput";
    }

    @GetMapping("/contactInput")
    public String contactInput(Model model){
        System.out.println("수정화면 이동");
        model.addAttribute("input",contactRepository.findAll());
        return "/category/contact";
    }
}
