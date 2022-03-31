package web.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    @Override
    public void addUser(String userName, String email, int age) {
        entityManager.persist(new User(userName, email, age));
    }

    @Override
    public User getUserById(int Id) {
        return entityManager.find(User.class, Id);
    }

    @Override
    public void deleteUserById(int Id) {
        entityManager.createQuery("DELETE User WHERE id =" + Id).executeUpdate();
    }

    @Override
    public void updateUser(int Id, String userName, String email, int age) {
        User user = entityManager.find(User.class, Id);
        user.setUserName(userName);
        user.setAge(age);
        user.setEmail(email);
        entityManager.merge(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }
}
