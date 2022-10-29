package pe.isil.moduloseguridad.user;

import java.util.List;

public interface UserService {

    void createUser(User user);
    void updateUser(User user, Long id);
    void deleteUser(Long id);
    User getUserByMail(String mail);
    List<User> getAllUsers();
}
