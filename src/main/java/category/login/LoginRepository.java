package category.login;

import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<User, Long> {
}
