package category.security;

import category.user.User;
import javax.servlet.http.HttpSession;

public class HttpSessionUtils {

    public static final String USER_SESSION_KEY = "login_user";

    //null 체크
    private static boolean isLoginUser (HttpSession session){
        Object loginUser = session.getAttribute(USER_SESSION_KEY);
        return loginUser != null;
    }

    //session
    public static User getUserFromSession(HttpSession session){
        if(isLoginUser(session) == true){
            User user = (User)session.getAttribute(USER_SESSION_KEY);
            return user;
        }
        return null;
    }
}
