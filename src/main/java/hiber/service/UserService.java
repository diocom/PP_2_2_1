package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface UserService {

    @Transactional
    void add(User user);

    List<User> listUsers();

    List<User> listUsersByCar(String model, int series);
}
