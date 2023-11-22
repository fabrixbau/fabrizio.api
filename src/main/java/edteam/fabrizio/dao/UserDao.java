package edteam.fabrizio.dao;

import edteam.fabrizio.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User get(long id);
    User register(User user);
    User update(User user);
    void delete(long id);
    public User login(User user);
}
