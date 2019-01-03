package category.service;

import category.user.UserRepository;
import category.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    public User login(String userId, String password) {

        return userRepository.findByUserId(userId).
                filter(x -> x.matchPassword(password)).orElseThrow(NullPointerException::new);
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findAllPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(String userId) {
        return userRepository.findByUserId(userId).orElse(null);
    }
    //Iterable과 List로 구현하는 차이  => JPA레파지토리 사용시 List로 반환 가능
    //Iterable => Crud레파지토리 사용시 리턴 값으로 적용 됨
    //JPA 레파지토리 + Crud 레파지토리의 차이

    public User masterUser() {
        String master = "ly91";
        return userRepository.findByUserId(master).orElseThrow(NullPointerException::new);
    }

}



