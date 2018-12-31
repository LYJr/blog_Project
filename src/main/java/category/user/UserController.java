package category.user;

import category.paging.UserListPage;
import category.security.HttpSessionUtils;
import category.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("")
    public String login(HttpSession session, String userId, String password) {
        //HTTPSession
        User user = userService.login(userId, password);
        session.setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
        return "/index";
    }

    @PostMapping("/form")
    public String loginForm(User user) {

        userService.add(user);

        return "/category/user";
    }

    @GetMapping("/list")
    public String UserList(Model model, HttpSession session, Pageable pageable) {
        User user = HttpSessionUtils.getUserFromSession(session);
        User master = userService.masterUser();

        if (master.getUserId() != user.getUserId()) {
            model.addAttribute("list", userService.findById(user.getUserId()));

            return "/category/user-list";
        }

        List<User> users = userService.findAll();
        log.debug("user size : {}", users.size());
//        model.addAttribute("list", userService.findAllPage(pageable));

        return "redirect:/users/list/page";
    }

    @GetMapping("/list/page")
    public String userListPaging(Model model, Optional<Integer> page,
                                 @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 2) Pageable pageable){

        Page<User> presentPage = userService.findAllPage(page, pageable);
        model.addAttribute("user", page);
        model.addAttribute("userListPage", UserListPage.of(presentPage));

       return "/category/user-list";
    }


}
