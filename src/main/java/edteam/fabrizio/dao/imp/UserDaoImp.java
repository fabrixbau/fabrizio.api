package edteam.fabrizio.dao.imp;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import edteam.fabrizio.dao.UserDao;
import edteam.fabrizio.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


@Transactional
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public List<User> getAll() {
        String hql = "FROM User as u ";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public User get(long id){
        return entityManager.find(User.class, id);
    }


    @Transactional
    @Override
    public User register(User user){
        entityManager.merge(user);
        return user;
    }


    @Transactional
    @Override
    public User update(User user){
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public void delete(long id){
        User user = get(id);
        entityManager.remove(user);
    }

    @Override
    public User login(User dto) {
        boolean isAuthenticated = false;

        String hql = "FROM User as u WHERE u.password is not null and u.email = :email";

        List<User> result = entityManager.createQuery(hql.toString())
                .setParameter("email", dto.getEmail())
                .getResultList();
        if (result.size() == 0) { return null; }

        User user = result.get(0);
        isAuthenticated = true;

        if (!StringUtils.isEmpty(dto.getPassword())) {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            isAuthenticated = argon2.verify(user.getPassword(), dto.getPassword());
        }
        if (isAuthenticated) {
            return user;
        }
        return null;
    }



}
