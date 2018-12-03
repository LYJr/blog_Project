package category.login;

import category.user.User;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<User, Long> {
}
