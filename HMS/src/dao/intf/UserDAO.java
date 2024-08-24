package dao.intf;

import models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
