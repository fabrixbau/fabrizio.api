package edteam.fabrizio.services;

import edteam.fabrizio.dao.UserDao;
import edteam.fabrizio.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User get(long id) {
        return userDao.get(id);
    }


    public User register(User user ) {
        return userDao.register(user);
    }

    public User update(@RequestBody User user){
        return userDao.update(user);
    }

    public void delete(@PathVariable long id){
        userDao.delete(id);
    }


}
